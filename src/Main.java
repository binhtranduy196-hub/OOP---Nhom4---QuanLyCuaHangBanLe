
import helper.InputHelper;
import models.*;
import services.ReportService;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
// Import lớp/thư viện cần sử dụng.
import java.time.LocalDate;
import java.util.Scanner;


/** Điểm chạy chương trình và giao diện menu console. */
// Khai báo lớp cụ thể của hệ thống.
public class Main {
    // Khai báo hằng số dùng chung trong lớp; private giới hạn truy cập và final không cho thay đổi.
    private static final String TITLE = "QUẢN LÝ CỬA HÀNG BÁN LẺ - OOP";

    // Hàm main là điểm bắt đầu chạy chương trình Java.
    public static void main(String[] args) {
        
        // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
        Store store = new Store("Cửa hàng bán lẻ", "Việt Nam");
        // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
        ReportService reports = new ReportService();

        // Bắt đầu vùng xử lý có thể phát sinh exception.
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
            InputHelper input = new InputHelper(scanner);
            seed(store);
            menu(store, reports, input);
        // Bắt exception để chương trình thông báo lỗi thay vì bị dừng đột ngột.
        } catch (Exception exception) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("Chương trình kết thúc an toàn: " + exception.getMessage());
        // Đóng khối lệnh hiện tại.
        }
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private static void menu(Store store, ReportService reports, InputHelper input) {
        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        boolean running = true;

        // Lặp lại xử lý khi điều kiện còn đúng.
        while (running) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("\n========== " + TITLE + " ==========");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("1. Thêm sản phẩm");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("2. Sửa sản phẩm");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("3. Xóa sản phẩm");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("4. Tìm kiếm sản phẩm");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("5. Hiển thị sản phẩm");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("6. Tạo đơn + thanh toán");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("7. Hiển thị nhân viên");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("8. Báo cáo doanh thu");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("9. Báo cáo tồn kho");
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("0. Thoát");

            // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
            int choice = input.readInt("Chọn: ", 0, 9);

            // Bắt đầu vùng xử lý có thể phát sinh exception.
            try {
                // Rẽ nhánh chương trình theo giá trị lựa chọn.
                switch (choice) {
                    // Xử lý các trường hợp cụ thể của switch.
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
                    // Xử lý trường hợp mặc định khi không khớp case.
                    default -> System.out.println("Lựa chọn không hợp lệ.");
                }
            // Bắt exception để chương trình thông báo lỗi thay vì bị dừng đột ngột.
            } catch (IllegalArgumentException | IllegalStateException exception) {
                // Hiển thị thông tin hoặc thông báo cho người dùng.
                System.out.println("Không thể thực hiện: " + exception.getMessage());
            }

            // Kiểm tra điều kiện trước khi thực hiện xử lý.
            if (running) {
                // Thực hiện câu lệnh Java tương ứng.
                input.pause();      
            }      
        }
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("Đã thoát chương trình.");
    }

    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private static void addProduct(Store store, InputHelper input) {
        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        int type = input.readInt(
                "Loại (1-Food, 2-Electronics, 3-Clothing): ", 1, 3);

        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        String id = input.readRequiredString("Mã sản phẩm: ");
        String name = input.readRequiredString("Tên sản phẩm: ");
        double price = input.readDouble("Giá: ", 0);
        int quantity = input.readInt("Số lượng tồn kho: ", 0, Integer.MAX_VALUE);

        Product product;
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (type == 1) {
            // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
            product = new Food(              
                    id,
                    name, 
                    price, 
                    quantity,                                
                    input.readDate("Hạn sử dụng (yyyy-MM-dd): "),
                    // Thực hiện câu lệnh Java tương ứng.
                    input.readRequiredString("Loại thực phẩm: "));
        // Kiểm tra điều kiện thay thế nếu điều kiện trước không đúng.
        } else if (type == 2) {
            // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
            product = new Electronics(               
                    id, 
                    name, 
                    price, 
                    quantity,
                    input.readRequiredString("Thương hiệu: "),                   
                    input.readInt("Bảo hành (tháng): ", 0, 120));
        // Thực hiện nhánh còn lại khi điều kiện trước không đúng.
        } else {
            // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
            product = new Clothing(
                    id,
                    name,
                    price,
                    quantity,     
                    input.readRequiredString("Size: "),               
                    input.readRequiredString("Màu: "));
        }
        // thêm sản phẩm vào cửa hàng bằng phương thức addProduct của đối tượng store.
        store.addProduct(product);
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("Đã thêm sản phẩm thành công.");
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private static void updateProduct(Store store, InputHelper input) {
        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        String id = input.readRequiredString("Mã sản phẩm cần sửa: ");
        Product oldProduct = store.searchProduct(id); // Tìm kiếm sản phẩm cũ trong cửa hàng bằng phương thức searchProduct của đối tượng store.

        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (oldProduct == null) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("Không tìm thấy sản phẩm.");
            // Kết thúc phương thức hiện tại.
            return;
        }

        String name = input.readRequiredString("Tên mới: ");
        double price = input.readDouble("Giá mới: ", 0);
        int quantity = input.readInt("Tồn kho mới: ", 0, Integer.MAX_VALUE);

        Product newProduct;

        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (oldProduct instanceof Food) {
            // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
            newProduct = new Food(
                    id,
                    name,
                    price,
                    quantity,
                    input.readDate("HSD mới (yyyy-MM-dd): "),
                    input.readRequiredString("Loại thực phẩm mới: "));
        // Kiểm tra điều kiện thay thế nếu điều kiện trước không đúng.
        } else if (oldProduct instanceof Electronics) {
            // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
            newProduct = new Electronics(
                    id,
                    name,
                    price,
                    quantity,
                    input.readRequiredString("Thương hiệu mới: "),
                    // Thực hiện câu lệnh Java tương ứng.
                    input.readInt("Bảo hành mới (tháng): ", 0, 120));
        // Thực hiện nhánh còn lại khi điều kiện trước không đúng.
        } else {
            // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
            newProduct = new Clothing(
                    id,
                    name,
                    price,
                    quantity,
                    input.readRequiredString("Size mới: "),  
                    input.readRequiredString("Màu mới: "));
        }
        // Cập nhật sản phẩm trong cửa hàng bằng phương thức updateProduct của đối tượng store.
        store.updateProduct(newProduct);
        System.out.println("Đã cập nhật sản phẩm.");
    }

    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private static void deleteProduct(Store store, InputHelper input) {
        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        String id = input.readRequiredString("Mã sản phẩm cần xóa: ");
        // Thực hiện câu lệnh Java tương ứng.
        Product product = store.searchProduct(id);

        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (product == null) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("Không tìm thấy sản phẩm.");
            // Kết thúc phương thức hiện tại.
            return;
        }
        if (input.confirm("Xóa " + product.getName() + "?")) { // Xác nhận xóa lấy thông tin sản phẩm bằng phương thức getName của đối tượng product.
            store.deleteProduct(id);
            System.out.println("Đã xóa sản phẩm.");
        }
    }

    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private static void searchProduct(Store store, InputHelper input) {

        String keyword = input.readRequiredString("Nhập mã hoặc tên sản phẩm: ");
        Product product = store.searchProduct(keyword);

        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (product != null) { //giá trị
            product.displayInfo(); // Hiển thị thông tin sản phẩm bằng phương thức displayInfo của đối tượng product.
            return;
        }

        var results = store.searchProductByName(keyword); // Tìm kiếm sản phẩm theo tên trong cửa hàng bằng phương thức searchProductByName của đối tượng store.
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm.");
        // Thực hiện nhánh còn lại khi điều kiện trước không đúng.
        } else {
            results.forEach(Product::displayInfo);
        }
    }

    /** Thanh toán: hiển thị nhân viên tính tiền và quản lý phụ trách. */
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private static void checkout(Store store, InputHelper input) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (store.getProducts().isEmpty()) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalStateException("Chưa có sản phẩm để bán.");
        }

        Customer customer = new Customer(               
                input.readRequiredString("Mã khách hàng: "),           
                input.readRequiredString("Tên khách hàng: "),
                input.readRequiredString("SĐT khách hàng: ")); 
        Employee cashier = store.findEmployee("NV01");
        Employee managerEmployee = store.findEmployee("QL01");

        if (!(managerEmployee instanceof Manager manager)) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalStateException("Chưa có quản lý phụ trách.");
 
        }
        if (cashier == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalStateException("Chưa có nhân viên tính tiền.");
        }

        Order order = customer.createOrder(input.readRequiredString("Mã đơn: "));//
        order.setCashier(cashier);
        // Gọi setter hoặc thực hiện thao tác cập nhật dữ liệu thông qua phương thức.
        order.setManager(manager);

        // Lặp lại xử lý khi điều kiện còn đúng.
        while (input.confirm("Thêm sản phẩm vào đơn?")) {
            // Dòng lệnh này thực hiện một phần xử lý của lớp.
            Product product = store.searchProduct(
                    input.readRequiredString("Mã sản phẩm: "));

            // Kiểm tra điều kiện trước khi thực hiện xử lý.
            if (product == null) {
                // Hiển thị thông tin hoặc thông báo cho người dùng.
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

    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private static void seed(Store store) {
        // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
        Manager manager = new Manager(
                "QL01", "Trần Duy Binh", "0900000001", "Manager");
        Staff staff = new Staff(
                "NV01", "Trần Thị Thu Ngân", "0900000002", "Staff", "Bán hàng");

        manager.addStaff(staff);
        store.addEmployee(manager);
        store.addEmployee(staff);

        store.addProduct(
            
                new Food("F01", "Sữa tươi", 32000, 50,                    
                        LocalDate.of(2026, 12, 31), "Đồ uống"),

                            new Electronics("E01", "Tai nghe Bluetooth", 450000, 20,                                            "Sony", 12),
                         new Clothing("C01", "Áo thun", 180000, 30,
             
                        "M", "Đen"));
    }
}
