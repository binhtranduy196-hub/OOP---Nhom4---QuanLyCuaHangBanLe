// Khai báo package chứa lớp này.
package models;
// Import lớp/thư viện cần sử dụng.
import java.util.*;
// Khai báo lớp cụ thể của hệ thống.
public class Customer {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String id,name,phone; 
    private final List<Order> orders=new ArrayList<>();
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Customer(){
        this("KH000","Khách hàng","0000000000");
    } 
    public Customer(String id,String name,String phone){
        setId(id);setName(name);setPhone(phone);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getId(){
        return id;
    } 
    public void setId(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Mã KH không được trống.");
    id = v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getName(){
        return name;
    } 
    public void setName(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Tên KH không được trống.");
        name=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getPhone(){
        return phone;
    } 
    public void setPhone(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("SĐT không được trống.");
        phone=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void createOrder(Order o){
        if(o==null)throw new IllegalArgumentException("Đơn hàng không được null.");
        if(!orders.contains(o))orders.add(o);
    } 
    public Order createOrder(String id){
        Order o = new Order(id,java.time.LocalDate.now(),Order.PENDING);
        createOrder(o);
        return o;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public List<Order> viewOrders(){
        return Collections.unmodifiableList(orders);
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override public String toString(){
        return String.format("[%s] %s | SĐT: %s | Số đơn: %d",id,name,phone,orders.size());
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override public boolean equals(Object o){
        return o instanceof Customer c&&Objects.equals(id,c.id);
    } 
    @Override public int hashCode(){
        return Objects.hash(id);
    }
// Đóng khối lệnh hiện tại.
}
