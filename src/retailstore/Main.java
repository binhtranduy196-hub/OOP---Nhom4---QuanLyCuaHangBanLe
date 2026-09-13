package retailstore;

import java.time.LocalDate;
import java.util.Scanner;

/** Điểm chạy chương trình và giao diện menu console. */
public class Main {
    private static final String TITLE = "QUẢN LÝ CỬA HÀNG BÁN LẺ - OOP";

    public static void main(String[] args) {
        Store store = new Store("Cửa hàng bán lẻ", "Huế");
        ReportService reports = new ReportService();

        try (Scanner scanner = new Scanner(System.in)) {
            InputHelper input = new InputHelper(scanner);
            seed(store);
            menu(store, reports, input);
        } catch (Exception exception) {
            System.out.println("Chương trình kết thúc an toàn: " + exception.getMessage());
        }
    }

    private static void menu(Store store, ReportService reports, InputHelper input) {
        boolean running = true;

        while (running) {
            System.out.println("\n========== " + TITLE + " ==========");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Tìm kiếm sản phẩm");
            System.out.println("5. Hiển thị sản phẩm");
            System.out.println("6. Tạo đơn + thanh toán");
            System.out.println("7. Hiển thị nhân viên");
            System.out.println("8. Báo cáo doanh thu");
            System.out.println("9. Báo cáo tồn kho");
            System.out.println("0. Thoát");

            int choice = input.readInt("Chọn: ", 0, 9);

            try {
                switch (choice) {
                    case 1 -> addProduct(store, input);
                    case 2 -> updateProduct(store, input);
                    case 3 -> deleteProduct(store, input);
                    case 4 -> searchProduct(store, input);
                    case 5 -> store.displayProducts();
                    case 6 -> checkout(store, input);
                    case 7 -> store.displayEmployees();
                    case 8 -> reports.printRevenueReport(store.getOrders());
                    case 9 -> reports.printInventoryReport(store.getProducts());
                    case 0 -> running = false;
                    default -> System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (IllegalArgumentException | IllegalStateException exception) {
                System.out.println("Không thể thực hiện: " + exception.getMessage());
            }

            if (running) {
                input.pause();
            }
        }

        System.out.println("Đã thoát chương trình.");
    }

    private static void addProduct(Store store, InputHelper input) {
        int type = input.readInt(
                "Loại (1-Food, 2-Electronics, 3-Clothing): ", 1, 3);

        String id = input.readRequiredString("Mã sản phẩm: ");
        String name = input.readRequiredString("Tên sản phẩm: ");
        double price = input.readDouble("Giá: ", 0);
        int quantity = input.readInt("Số lượng tồn kho: ", 0, Integer.MAX_VALUE);

        Product product;

        if (type == 1) {
            product = new Food(
                    id,
                    name,
                    price,
                    quantity,
                    input.readDate("Hạn sử dụng (yyyy-MM-dd): "),
                    input.readRequiredString("Loại thực phẩm: "));
        } else if (type == 2) {
            product = new Electronics(
                    id,
                    name,
                    price,
                    quantity,
                    input.readRequiredString("Thương hiệu: "),
                    input.readInt("Bảo hành (tháng): ", 0, 120));
        } else {
            product = new Clothing(
                    id,
                    name,
                    price,
                    quantity,
                    input.readRequiredString("Size: "),
                    input.readRequiredString("Màu: "));
        }

        store.addProduct(product);
        System.out.println("Đã thêm sản phẩm thành công.");
    }

    private static void updateProduct(Store store, InputHelper input) {
        String id = input.readRequiredString("Mã sản phẩm cần sửa: ");
        Product oldProduct = store.searchProduct(id);

        if (oldProduct == null) {
            System.out.println("Không tìm thấy sản phẩm.");
            return;
        }

        String name = input.readRequiredString("Tên mới: ");
        double price = input.readDouble("Giá mới: ", 0);
        int quantity = input.readInt("Tồn kho mới: ", 0, Integer.MAX_VALUE);

        Product newProduct;

        if (oldProduct instanceof Food) {
            newProduct = new Food(
                    id,
                    name,
                    price,
                    quantity,
                    input.readDate("HSD mới (yyyy-MM-dd): "),
                    input.readRequiredString("Loại thực phẩm mới: "));
        } else if (oldProduct instanceof Electronics) {
            newProduct = new Electronics(
                    id,
                    name,
                    price,
                    quantity,
                    input.readRequiredString("Thương hiệu mới: "),
                    input.readInt("Bảo hành mới (tháng): ", 0, 120));
        } else {
            newProduct = new Clothing(
                    id,
                    name,
                    price,
                    quantity,
                    input.readRequiredString("Size mới: "),
                    input.readRequiredString("Màu mới: "));
        }

        store.updateProduct(newProduct);
        System.out.println("Đã cập nhật sản phẩm.");
    }

    private static void deleteProduct(Store store, InputHelper input) {
        String id = input.readRequiredString("Mã sản phẩm cần xóa: ");
        Product product = store.searchProduct(id);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm.");
            return;
        }

        if (input.confirm("Xóa " + product.getName() + "?")) {
            store.deleteProduct(id);
            System.out.println("Đã xóa sản phẩm.");
        }
    }

    private static void searchProduct(Store store, InputHelper input) {
        String keyword = input.readRequiredString("Nhập mã hoặc tên sản phẩm: ");
        Product product = store.searchProduct(keyword);

        if (product != null) {
            product.displayInfo();
            return;
        }

        var results = store.searchProductByName(keyword);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else {
            results.forEach(Product::displayInfo);
        }
    }

    /** Thanh toán: hiển thị nhân viên tính tiền và quản lý phụ trách. */
    private static void checkout(Store store, InputHelper input) {
        if (store.getProducts().isEmpty()) {
            throw new IllegalStateException("Chưa có sản phẩm để bán.");
        }

        Customer customer = new Customer(
                input.readRequiredString("Mã khách hàng: "),
                input.readRequiredString("Tên khách hàng: "),
                input.readRequiredString("SĐT khách hàng: "));

        Employee cashier = store.findEmployee("NV01");
        Employee managerEmployee = store.findEmployee("QL01");

        if (!(managerEmployee instanceof Manager manager)) {
            throw new IllegalStateException("Chưa có quản lý phụ trách.");
        }
        if (cashier == null) {
            throw new IllegalStateException("Chưa có nhân viên tính tiền.");
        }

        Order order = customer.createOrder(input.readRequiredString("Mã đơn: "));
        order.setCashier(cashier);
        order.setManager(manager);

        while (input.confirm("Thêm sản phẩm vào đơn?")) {
            Product product = store.searchProduct(
                    input.readRequiredString("Mã sản phẩm: "));

            if (product == null) {
                System.out.println("Không tìm thấy sản phẩm.");
                continue;
            }

            int quantity = input.readInt(
                    "Số lượng: ", 1, product.getQuantity());
            order.addProduct(product, quantity);
        }

        order.checkout();
        store.addOrder(order);
        order.printInvoice();
    }

    /** Tạo dữ liệu mẫu để dễ kiểm tra chương trình. */
    private static void seed(Store store) {
        Manager manager = new Manager(
                "QL01", "Nguyễn Văn Quản", "0900000001", "Manager");
        Staff staff = new Staff(
                "NV01", "Trần Văn Nhân", "0900000002", "Staff", "Bán hàng");

        manager.addStaff(staff);
        store.addEmployee(manager);
        store.addEmployee(staff);

        store.addProduct(
                new Food("F01", "Sữa tươi", 32000, 50,
                        LocalDate.of(2026, 12, 31), "Đồ uống"),
                new Electronics("E01", "Tai nghe Bluetooth", 450000, 20,
                        "Sony", 12),
                new Clothing("C01", "Áo thun", 180000, 30,
                        "M", "Đen"));
    }
}
