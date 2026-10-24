// Khai báo package chứa lớp này.
package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Khai báo lớp cụ thể của hệ thống.
public class Store {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String name;
    private String address;
    // Khai báo thuộc tính private và final; danh sách/tham chiếu được gán một lần.
    private final List<Product> products = new ArrayList<>();
    // Khai báo thuộc tính private và final; danh sách/tham chiếu được gán một lần.
    private final List<Employee> employees = new ArrayList<>();
    // Khai báo thuộc tính private và final; danh sách/tham chiếu được gán một lần.
    private final List<Order> orders = new ArrayList<>();

    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Store() {
        // Gọi constructor khác của cùng lớp để tái sử dụng mã khởi tạo.
        this("Cửa hàng bán lẻ", "Chưa cập nhật");
   
    }

    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Store(String name, String address) {
        // Gọi setter hoặc thực hiện thao tác cập nhật dữ liệu thông qua phương thức.
        setName(name);
        // Gọi setter hoặc thực hiện thao tác cập nhật dữ liệu thông qua phương thức.
        setAddress(address);
  
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getName() {
        // Trả kết quả của phương thức về nơi gọi.
        return name;
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void setName(String name) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (name == null || name.isBlank()) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Tên cửa hàng không được để trống.");
        }
        // Thực hiện câu lệnh Java tương ứng.
        this.name = name.trim();
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getAddress() {
        // Trả kết quả của phương thức về nơi gọi.
        return address;
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void setAddress(String address) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (address == null || address.isBlank()) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Địa chỉ không được để trống.");
        }
        // Thực hiện câu lệnh Java tương ứng.
        this.address = address.trim();
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public List<Product> getProducts() {
        // Trả kết quả của phương thức về nơi gọi.
        return Collections.unmodifiableList(products);
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public List<Employee> getEmployees() {
        // Trả kết quả của phương thức về nơi gọi.
        return Collections.unmodifiableList(employees);
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public List<Order> getOrders() {
        // Trả kết quả của phương thức về nơi gọi.
        return Collections.unmodifiableList(orders);
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addProduct(Product product) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (product == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Sản phẩm không được null.");
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (searchProduct(product.getId()) != null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Mã sản phẩm đã tồn tại.");
        }
        // Thực hiện câu lệnh Java tương ứng.
        products.add(product);
    }

    /** Overload: thêm nhiều sản phẩm. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addProduct(Product... products) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (products == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Danh sách sản phẩm không được null.");
        // Đóng khối lệnh hiện tại.
        }
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (Product product : products) {
            // Thực hiện câu lệnh Java tương ứng.
            addProduct(product);
        }
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public Product searchProduct(String id) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (id == null || id.isBlank()) {
            // Trả kết quả của phương thức về nơi gọi.
            return null;
        }
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (Product product : products) {
            // Kiểm tra điều kiện trước khi thực hiện xử lý.
            if (product.getId().equalsIgnoreCase(id.trim())) {
                // Trả kết quả của phương thức về nơi gọi.
                return product;
            }
        }
        // Trả kết quả của phương thức về nơi gọi.
        return null;
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public List<Product> searchProductByName(String keyword) {
        // Tạo đối tượng mới và gán tham chiếu cho biến tương ứng.
        List<Product> result = new ArrayList<>();
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (keyword == null) {
            // Trả kết quả của phương thức về nơi gọi.
            return result;
        }

        // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
        String key = keyword.trim().toLowerCase();
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (Product product : products) {
            // Kiểm tra điều kiện trước khi thực hiện xử lý.
            if (product.getName().toLowerCase().contains(key)) {
                // Thực hiện câu lệnh Java tương ứng.
                result.add(product);
            }
        }
        // Trả kết quả của phương thức về nơi gọi.
        return result;
    }

    /** Cập nhật sản phẩm theo mã. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void updateProduct(Product product) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (product == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Sản phẩm không được null.");
        // Đóng khối lệnh hiện tại.
        }

        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (int index = 0; index < products.size(); index++) {
            // Kiểm tra điều kiện trước khi thực hiện xử lý.
            if (products.get(index).getId().equalsIgnoreCase(product.getId())) {
                // Gọi setter hoặc thực hiện thao tác cập nhật dữ liệu thông qua phương thức.
                products.set(index, product);
                // Kết thúc phương thức hiện tại.
                return;
            // Đóng khối lệnh hiện tại.
            }
        // Đóng khối lệnh hiện tại.
        }
        // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
        throw new IllegalArgumentException("Không tìm thấy sản phẩm để sửa.");
    // Đóng khối lệnh hiện tại.
    }

    // Chú thích JavaDoc mô tả thành phần bên dưới.
    /** Xóa sản phẩm theo mã. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void deleteProduct(String id) {
        // Thực hiện câu lệnh Java tương ứng.
        Product product = searchProduct(id);
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (product == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Không tìm thấy sản phẩm để xóa.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        products.remove(product);
    // Đóng khối lệnh hiện tại.
    }

    // Chú thích JavaDoc mô tả thành phần bên dưới.
    /** Thêm nhân viên vào cửa hàng. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addEmployee(Employee employee) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (employee == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Nhân viên không được null.");
        // Đóng khối lệnh hiện tại.
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (findEmployee(employee.getEmployeeId()) != null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Mã nhân viên đã tồn tại.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        employees.add(employee);
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public Employee findEmployee(String employeeId) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (employeeId == null || employeeId.isBlank()) {
            // Trả kết quả của phương thức về nơi gọi.
            return null;
        // Đóng khối lệnh hiện tại.
        }
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (Employee employee : employees) {
            // Kiểm tra điều kiện trước khi thực hiện xử lý.
            if (employee.getEmployeeId().equalsIgnoreCase(employeeId.trim())) {
                // Trả kết quả của phương thức về nơi gọi.
                return employee;
            // Đóng khối lệnh hiện tại.
            }
        // Đóng khối lệnh hiện tại.
        }
        // Trả kết quả của phương thức về nơi gọi.
        return null;
    // Đóng khối lệnh hiện tại.
    }

    // Chú thích JavaDoc mô tả thành phần bên dưới.
    /** Thêm đơn hàng sau khi kiểm tra mã đơn không trùng. */
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addOrder(Order order) {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (order == null) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Đơn hàng không được null.");
        // Đóng khối lệnh hiện tại.
        }
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (orders.contains(order)) {
            // Chủ động phát sinh exception khi dữ liệu hoặc trạng thái không hợp lệ.
            throw new IllegalArgumentException("Mã đơn hàng đã tồn tại.");
        // Đóng khối lệnh hiện tại.
        }
        // Thực hiện câu lệnh Java tương ứng.
        orders.add(order);
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void displayProducts() {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (products.isEmpty()) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("Chưa có sản phẩm.");
            // Kết thúc phương thức hiện tại.
            return;
        // Đóng khối lệnh hiện tại.
        }

        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("\n===== DANH SÁCH SẢN PHẨM =====");
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (Product product : products) {
            // Thực hiện câu lệnh Java tương ứng.
            product.displayInfo();
        // Đóng khối lệnh hiện tại.
        }
    // Đóng khối lệnh hiện tại.
    }

    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void displayEmployees() {
        // Kiểm tra điều kiện trước khi thực hiện xử lý.
        if (employees.isEmpty()) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println("Chưa có nhân viên.");
            // Kết thúc phương thức hiện tại.
            return;
        // Đóng khối lệnh hiện tại.
        }

        // Hiển thị thông tin hoặc thông báo cho người dùng.
        System.out.println("\n===== DANH SÁCH NHÂN VIÊN =====");
        // Duyệt qua các phần tử hoặc lặp theo điều kiện đã xác định.
        for (Employee employee : employees) {
            // Hiển thị thông tin hoặc thông báo cho người dùng.
            System.out.println(employee);
        // Đóng khối lệnh hiện tại.
        }
    // Đóng khối lệnh hiện tại.
    }
// Đóng khối lệnh hiện tại.
}
