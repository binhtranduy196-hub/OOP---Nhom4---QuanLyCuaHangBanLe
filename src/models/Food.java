
// Khai báo package chứa lớp này.
package models;
// Import lớp/thư viện cần sử dụng.
import java.time.LocalDate;
// Khai báo lớp cụ thể của hệ thống.
public class Food extends Product {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private LocalDate expiryDate; 
    private String foodType;
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Food(){
        this("F000","Thực phẩm",0,0,LocalDate.now(),"Khác");
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Food(String id,String name,double price,int quantity,LocalDate expiryDate,String foodType){
        super(id,name,price,quantity);
        setExpiryDate(expiryDate);
        setFoodType(foodType);
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Food(Food o){
        this(o.getId(),o.getName(),o.getPrice(),o.getQuantity(),o.expiryDate,o.foodType);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public LocalDate getExpiryDate(){
        return expiryDate;
    } 
    public void setExpiryDate(LocalDate v){
        if(v==null)throw new IllegalArgumentException("HSD không được null.");
        expiryDate=v;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getFoodType(){
        return foodType;
    } 
    public void setFoodType(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Loại thực phẩm không được trống.");
        foodType=v.trim();
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public void displayInfo(){
        System.out.printf("%s | HSD: %s | Loại: %s%n",this,expiryDate,foodType);
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public String getCategory(){
        return "Food";
    } 
    @Override 
    public double calculateDiscount(){
        return getPrice()*0.05;

    }
// Đóng khối lệnh hiện tại.
}
