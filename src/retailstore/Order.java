package retailstore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Đơn hàng của khách hàng. Order có composition với OrderItem. */
public class Order {
    public static final String PAID = "PAID";
    public static final String PENDING = "PENDING";

    private String orderId;
    private LocalDate date;
    private String status;
    private final List<OrderItem> items = new ArrayList<>();
    private Employee cashier;
    private Manager manager;

    public Order() {
        this("DH000", LocalDate.now(), PENDING);
    }

    public Order(String orderId, LocalDate date, String status) {
        setOrderId(orderId);
        setDate(date);
        setStatus(status);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Mã đơn hàng không được để trống.");
        }
        this.orderId = orderId.trim();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Ngày lập đơn không được null.");
        }
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!PAID.equals(status) && !PENDING.equals(status)) {
            throw new IllegalArgumentException("Trạng thái chỉ được là PAID hoặc PENDING.");
        }
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        if (cashier == null) {
            throw new IllegalArgumentException("Nhân viên tính tiền không được null.");
        }
        this.cashier = cashier;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        if (manager == null) {
            throw new IllegalArgumentException("Quản lý phụ trách không được null.");
        }
        this.manager = manager;
    }

    /** Overload: thêm một sản phẩm với số lượng mặc định là 1. */
    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    /** Thêm sản phẩm vào đơn và tạo OrderItem mới. */
    public void addProduct(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Sản phẩm không được null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0.");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException(
                    "Không đủ tồn kho cho sản phẩm: " + product.getName());
        }
        items.add(new OrderItem(product, quantity));
    }

    public void removeProduct(String productId) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("Mã sản phẩm không được trống.");
        }

        boolean removed = items.removeIf(item ->
                item.getProduct().getId().equalsIgnoreCase(productId.trim()));

        if (!removed) {
            throw new IllegalArgumentException("Sản phẩm không tồn tại trong đơn.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    /** Thanh toán đơn hàng và trừ số lượng tồn kho. */
    public void checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Đơn hàng chưa có sản phẩm.");
        }
        if (cashier == null) {
            throw new IllegalStateException("Chưa chọn nhân viên tính tiền.");
        }
        if (manager == null) {
            throw new IllegalStateException("Chưa chọn quản lý phụ trách.");
        }
        if (PAID.equals(status)) {
            throw new IllegalStateException("Đơn hàng này đã thanh toán.");
        }

        for (OrderItem item : items) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }
        status = PAID;
    }

    /** In hóa đơn, đồng thời hiển thị nhân viên và quản lý phụ trách. */
    public void printInvoice() {
        System.out.println("\n========== HÓA ĐƠN ==========");
        System.out.println("Mã đơn: " + orderId);
        System.out.println("Ngày: " + date);
        System.out.println("Trạng thái: " + status);
        System.out.println("Nhân viên tính tiền: " + cashier);
        System.out.println("Quản lý phụ trách: " + manager);

        System.out.println("--- Chi tiết ---");
        for (OrderItem item : items) {
            System.out.println(item);
        }

        System.out.printf("TỔNG TIỀN: %,.0f VNĐ%n", calculateTotal());
        System.out.println("==============================");
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | Tổng: %,.0f VNĐ",
                orderId, date, status, calculateTotal());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Order other)) {
            return false;
        }
        return Objects.equals(orderId, other.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
