
// Khai báo package chứa lớp này.
package models;

// Import lớp/thư viện cần sử dụng.
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// Chú thích JavaDoc mô tả thành phần bên dưới.
/** Đơn hàng của khách hàng. Order có composition với OrderItem. */
// Khai báo lớp cụ thể của hệ thống.
public class Order {
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public static final String PAID = "PAID";
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public static final String PENDING = "PENDING";

    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String orderId;
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private LocalDate date;
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String status;
    // Khai báo thuộc tính private và final; danh sách/tham chiếu được gán một lần.
    private final List<OrderItem> items = new ArrayList<>();
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private Employee cashier;
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private Manager manager;

    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Order() {
        // Gọi constructor khác của cùng lớp để tái sử dụng mã khởi tạo.
        this("DH000", LocalDate.now(), PENDING);
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Order(String orderId, LocalDate date, String status) {
        // Gọi setter hoặc thực hiện thao tác cập nhật dữ liệu thông qua phương thức.
        setOrderId(orderId);
        // Gọi setter hoặc thực hiện thao tác cập nhật dữ liệu thông qua phương thức.
        setDate(date);
        // Gọi setter hoặc thực hiện thao tác cập nhật dữ liệu thông qua phương thức.
        setStatus(status);
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getOrderId() {
        // Trả kết quả của phương thức về nơi gọi.
        return orderId;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void setOrderId(String orderId) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (orderId == null || orderId.isBlank()) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Mã đơn hàng không được để trống.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        this.orderId = orderId.trim();
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public LocalDate getDate() {
        // Trả kết quả của phương thức về nơi gọi.
        return date;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void setDate(LocalDate date) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (date == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Ngày lập đơn không được null.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        this.date = date;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getStatus() {
        // Trả kết quả của phương thức về nơi gọi.
        return status;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void setStatus(String status) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (!PAID.equals(status) && !PENDING.equals(status)) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Trạng thái chỉ được là PAID hoặc PENDING.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        this.status = status;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public List<OrderItem> getItems() {
        // Trả kết quả của phương thức về nơi gọi.
        return Collections.unmodifiableList(items);
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public Employee getCashier() {
        // Trả kết quả của phương thức về nơi gọi.
        return cashier;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void setCashier(Employee cashier) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (cashier == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Nhân viên tính tiền không được null.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        this.cashier = cashier;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public Manager getManager() {
        // Trả kết quả của phương thức về nơi gọi.
        return manager;
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void setManager(Manager manager) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (manager == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Quản lý phụ trách không được null.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        this.manager = manager;
    // Đóng khối lệnh hiện tại.
    }

    // Chú thích JavaDoc mô tả thành phần bên dưới.
    /** Overload: thêm một sản phẩm với số lượng mặc định là 1. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addProduct(Product product) {
        // Thực hiện câu lệnh Java tương ứng.
        addProduct(product, 1);
    // Đóng khối lệnh hiện tại.
    }

    // Chú thích JavaDoc mô tả thành phần bên dưới.
    /** Thêm sản phẩm vào đơn và tạo OrderItem mới. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addProduct(Product product, int quantity) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (product == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Sản phẩm không được null.");
        // Đóng khối lệnh hiện tại.
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (quantity <= 0) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0.");
        // Đóng khối lệnh hiện tại.
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (quantity > product.getQuantity()) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException(
                    // Gọi getter hoặc lấy dữ liệu từ đối tượng.
                    "Không đủ tồn kho cho sản phẩm: " + product.getName());
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        items.add(new OrderItem(product, quantity));
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void removeProduct(String productId) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (productId == null || productId.isBlank()) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Mã sản phẩm không được trống.");
        // Đóng khối lệnh hiện tại.
        }

        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        boolean removed = items.removeIf(item ->
                // Gọi getter hoặc lấy dữ liệu từ đối tượng.
                item.getProduct().getId().equalsIgnoreCase(productId.trim()));

        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (!removed) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Sản phẩm không tồn tại trong đơn.");
        // Đóng khối lệnh hiện tại.
        }
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public double calculateTotal() {
        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        double total = 0;
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (OrderItem item : items) {
            // Gọi getter hoặc lấy dữ liệu từ đối tượng.
            total += item.getSubtotal();
        // Đóng khối lệnh hiện tại.
        }
        // Trả kết quả của phương thức về nơi gọi.
        return total;
    // Đóng khối lệnh hiện tại.
    }

    // Chú thích JavaDoc mô tả thành phần bên dưới.
    /** Thanh toán đơn hàng và trừ số lượng tồn kho. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void checkout() {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (items.isEmpty()) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalStateException("Đơn hàng chưa có sản phẩm.");
        // Đóng khối lệnh hiện tại.
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (cashier == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalStateException("Chưa chọn nhân viên tính tiền.");
        // Đóng khối lệnh hiện tại.
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (manager == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalStateException("Chưa chọn quản lý phụ trách.");
        // Đóng khối lệnh hiện tại.
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (PAID.equals(status)) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalStateException("Đơn hàng này đã thanh toán.");
        // Đóng khối lệnh hiện tại.
        }

        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (OrderItem item : items) {
            // Gọi getter hoặc lấy dữ liệu từ đối tượng.
            item.getProduct().decreaseQuantity(item.getQuantity());
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        status = PAID;
    // Đóng khối lệnh hiện tại.
    }

    // Chú thích JavaDoc mô tả thành phần bên dưới.
    /** In hóa đơn, đồng thời hiển thị nhân viên và quản lý phụ trách. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void printInvoice() {
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("\n========== HÓA ĐƠN ==========");
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("Mã đơn: " + orderId);
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("Ngày: " + date);
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("Trạng thái: " + status);
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("Nhân viên tính tiền: " + cashier);
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("Quản lý phụ trách: " + manager);

        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("--- Chi tiết ---");
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (OrderItem item : items) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println(item);
        // Đóng khối lệnh hiện tại.
        }

        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.printf("TỔNG TIỀN: %,.0f VNĐ%n", calculateTotal());
        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("==============================");
    // Đóng khối lệnh hiện tại.
    }

    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String toString() {
        // Trả kết quả của phương thức về nơi gọi.
        return String.format("[%s] %s | %s | Tổng: %,.0f VNĐ",
                // Thực hiện câu lệnh Java tương ứng.
                orderId, date, status, calculateTotal());
    // Đóng khối lệnh hiện tại.
    }

    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public boolean equals(Object object) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (!(object instanceof Order other)) {
            // Trả kết quả của phương thức về nơi gọi.
            return false;
        // Đóng khối lệnh hiện tại.
        }
        // Trả kết quả của phương thức về nơi gọi.
        return Objects.equals(orderId, other.orderId);
    // Đóng khối lệnh hiện tại.
    }

    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public int hashCode() {
        // Trả kết quả của phương thức về nơi gọi.
        return Objects.hash(orderId);
    // Đóng khối lệnh hiện tại.
    }
// Đóng khối lệnh hiện tại.
}
