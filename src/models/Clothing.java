// Khai báo package chứa lớp này.
package models;
// Khai báo lớp cụ thể của hệ thống.
public class Clothing extends Product {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String size; 
    private String color;
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Clothing(){
        this("C000","Quần áo",0,0,"M","Chưa rõ");}
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Clothing(String id,String name,double price,int quantity,String size,String color){
        super(id,name,price,quantity);setSize(size);setColor(color);
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Clothing(Clothing o){
        this(o.getId(),o.getName(),o.getPrice(),o.getQuantity(),o.size,o.color);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getSize(){
        return size;
    } 
    public void setSize(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Kích thước không được trống.");size=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getColor(){
        return color;
    } 
    public void setColor(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Màu sắc không được trống.");
        color=v.trim();}
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override public void displayInfo(){
        System.out.printf("%s | Size: %s | Màu: %s%n",this,size,color);
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override public String getCategory(){
        return "Clothing";
    } 
    @Override public double calculateDiscount(){
        return getPrice()*0.15;
    }
}
