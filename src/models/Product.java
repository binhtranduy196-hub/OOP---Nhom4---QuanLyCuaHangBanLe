
// Khai báo package chứa lớp này.
package models;
import services.Discountable;
import services.Sellable;
// Import lớp/thư viện cần sử dụng.
import java.util.Objects;
// Khai báo lớp trừu tượng, dùng làm lớp cha và không tạo đối tượng trực tiếp.
public abstract class Product implements Sellable, Discountable {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String id; 
    private String name; 
    private double price; 
    private int quantity;
    
    protected static final double MIN_PRICE = 0.0; // Khai báo hằng số protected để các lớp con có thể truy cập.
    protected static final int MIN_QUANTITY = 0;   // Khai báo hằng số protected để các lớp con có thể truy cập.
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Product(){ 
        this("P000","Chưa đặt tên",0,0); }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Product(String id,String name,double price,int quantity){
         setId(id);setName(name);setPrice(price);setQuantity(quantity); 
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Product(Product other){ 
        this(other.id,other.name,other.price,other.quantity); 
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getId(){

        return id;
    } 
    public void setId(String v) {
           if(v==null||v.isBlank())throw new IllegalArgumentException("Mã sản phẩm không được trống.");
           id=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getName(){
        return name;
    } 
    public void setName(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Tên sản phẩm không được trống.");
        name=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public double getPrice(){
        return price;
    } 
    public void setPrice(double v){
        if(Double.isNaN(v)||Double.isInfinite(v)||v<0)throw new IllegalArgumentException("Giá phải >= 0.");
        price = v;    
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int v){
        if(v<0)throw new IllegalArgumentException("Tồn kho phải >= 0.");
        quantity = v;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void increaseQuantity(int v){
        if(v<=0)throw new IllegalArgumentException("Số lượng nhập thêm phải > 0.");
        quantity += v;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void decreaseQuantity(int v){
        if(v<=0)throw new IllegalArgumentException("Số lượng xuất phải > 0.");
        if(v>quantity)throw new IllegalArgumentException("Không đủ tồn kho.");
        quantity -= v;
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public double calculatePrice(){
        return price;
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public void showSaleInfo(){
        System.out.printf("%s - %s: %,.0f VNĐ%n",id,name,calculatePrice());
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public double calculateDiscount(){
        return 0;
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public String getDiscountInfo(){
        return "Giảm giá: "+ String.format("%,.0f",calculateDiscount())+" VNĐ";
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public abstract void displayInfo(); 
    public abstract String getCategory();
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public String toString(){
        return String.format("[%s] %s | Giá: %,.0f | Tồn: %d | Loại: %s",id,name,price,quantity,getCategory());
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public boolean equals(Object o){
        return o instanceof Product p && Objects.equals(id,p.id);
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public int hashCode(){
        return Objects.hash(id);
    }
// Đóng khối lệnh hiện tại.
}
