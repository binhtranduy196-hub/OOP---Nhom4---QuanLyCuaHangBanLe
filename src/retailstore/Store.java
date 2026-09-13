package retailstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Quản lý sản phẩm, nhân viên và đơn hàng của cửa hàng. */
public class Store {
    private String name;
    private String address;
    private final List<Product> products = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public Store() {
        this("Cửa hàng bán lẻ", "Chưa cập nhật");
    }

    public Store(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Tên cửa hàng không được để trống.");
        }
        this.name = name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Địa chỉ không được để trống.");
        }
        this.address = address.trim();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    /** Thêm sản phẩm. */
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Sản phẩm không được null.");
        }
        if (searchProduct(product.getId()) != null) {
            throw new IllegalArgumentException("Mã sản phẩm đã tồn tại.");
        }
        products.add(product);
    }

    /** Overload: thêm nhiều sản phẩm. */
    public void addProduct(Product... products) {
        if (products == null) {
            throw new IllegalArgumentException("Danh sách sản phẩm không được null.");
        }
        for (Product product : products) {
            addProduct(product);
        }
    }

    public Product searchProduct(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id.trim())) {
                return product;
            }
        }
        return null;
    }

    public List<Product> searchProductByName(String keyword) {
        List<Product> result = new ArrayList<>();
        if (keyword == null) {
            return result;
        }

        String key = keyword.trim().toLowerCase();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(key)) {
                result.add(product);
            }
        }
        return result;
    }

    /** Cập nhật sản phẩm theo mã. */
    public void updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Sản phẩm không được null.");
        }

        for (int index = 0; index < products.size(); index++) {
            if (products.get(index).getId().equalsIgnoreCase(product.getId())) {
                products.set(index, product);
                return;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy sản phẩm để sửa.");
    }

    /** Xóa sản phẩm theo mã. */
    public void deleteProduct(String id) {
        Product product = searchProduct(id);
        if (product == null) {
            throw new IllegalArgumentException("Không tìm thấy sản phẩm để xóa.");
        }
        products.remove(product);
    }

    /** Thêm nhân viên vào cửa hàng. */
    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Nhân viên không được null.");
        }
        if (findEmployee(employee.getEmployeeId()) != null) {
            throw new IllegalArgumentException("Mã nhân viên đã tồn tại.");
        }
        employees.add(employee);
    }

    public Employee findEmployee(String employeeId) {
        if (employeeId == null || employeeId.isBlank()) {
            return null;
        }
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equalsIgnoreCase(employeeId.trim())) {
                return employee;
            }
        }
        return null;
    }

    /** Thêm đơn hàng sau khi kiểm tra mã đơn không trùng. */
    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Đơn hàng không được null.");
        }
        if (orders.contains(order)) {
            throw new IllegalArgumentException("Mã đơn hàng đã tồn tại.");
        }
        orders.add(order);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Chưa có sản phẩm.");
            return;
        }

        System.out.println("\n===== DANH SÁCH SẢN PHẨM =====");
        for (Product product : products) {
            product.displayInfo();
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Chưa có nhân viên.");
            return;
        }

        System.out.println("\n===== DANH SÁCH NHÂN VIÊN =====");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
