// Khai báo package chứa lớp này.
package models;
// Khai báo lớp cụ thể của hệ thống.
public class Electronics extends Product {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String brand; 
    private int warrantyMonths;
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Electronics(){
        this("E000","Thiết bị điện tử",0,0,"Chưa rõ",0);
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Electronics(String id,String name,double price,int quantity,String brand,int warrantyMonths){
        super(id,name,price,quantity);
        setBrand(brand);
        setWarrantyMonths(warrantyMonths);
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Electronics(Electronics o){
        this(o.getId(),o.getName(),o.getPrice(),o.getQuantity(),o.brand,o.warrantyMonths);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getBrand(){
        return brand;
    } 
    public void setBrand(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Thương hiệu không được trống.");brand=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public int getWarrantyMonths(){
        return warrantyMonths;} 
        public void setWarrantyMonths(int v){if(v<0)throw new IllegalArgumentException("Bảo hành phải >= 0.");
        warrantyMonths = v;
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public void displayInfo(){
        System.out.printf("%s | Hãng: %s | Bảo hành: %d tháng%n",this,brand,warrantyMonths);
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public String getCategory(){
        return "Electronics";
    } 
    @Override 
    public double calculateDiscount(){return getPrice()*0.10;  
    }
// Đóng khối lệnh hiện tại.
}
