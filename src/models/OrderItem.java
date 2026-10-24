
// Khai báo package chứa lớp này.
package models;
import java.util.Objects;
// Khai báo lớp cụ thể của hệ thống.
public class OrderItem {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private int quantity; 
    private double unitPrice; 
    private final Product product;
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public OrderItem(){
        this(null,0,0);
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public OrderItem(Product product,int quantity){
        this(product,quantity,product==null?0:product.getPrice());
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public OrderItem(Product product,int quantity,double unitPrice){
        if(product==null)throw new IllegalArgumentException("Sản phẩm không được null.");
        if(quantity<=0)throw new IllegalArgumentException("Số lượng mua phải > 0.");
        if(unitPrice<0)throw new IllegalArgumentException("Đơn giá phải >= 0.");
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public int getQuantity(){
        return quantity;
    } 
    public void setQuantity(int v){
        if(v<=0)throw new IllegalArgumentException("Số lượng mua phải > 0.");
        quantity=v;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public double getUnitPrice(){
        return unitPrice;
    } 
    public void setUnitPrice(double v){
        if(v<0)throw new IllegalArgumentException("Đơn giá phải >= 0.");
        unitPrice=v;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public Product getProduct(){
        return product;
    }
    public double getSubtotal(){
        return quantity*unitPrice;
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override public String toString(){
        return String.format("%s | SL: %d | Đơn giá: %,.0f | Thành tiền: %,.0f",product.getName(),quantity,unitPrice,getSubtotal());
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override public boolean equals(Object o){
        return o instanceof OrderItem i&&Objects.equals(product,i.product);
    }
    @Override public int hashCode(){
        return Objects.hash(product);
    }
// Đóng khối lệnh hiện tại.
}
