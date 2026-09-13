package retailstore;
public class Electronics extends Product {
    private String brand; private int warrantyMonths;
    public Electronics(){this("E000","Thiết bị điện tử",0,0,"Chưa rõ",0);}
    public Electronics(String id,String name,double price,int quantity,String brand,int warrantyMonths){super(id,name,price,quantity);setBrand(brand);setWarrantyMonths(warrantyMonths);}
    public Electronics(Electronics o){this(o.getId(),o.getName(),o.getPrice(),o.getQuantity(),o.brand,o.warrantyMonths);}
    public String getBrand(){return brand;} public void setBrand(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Thương hiệu không được trống.");brand=v.trim();}
    public int getWarrantyMonths(){return warrantyMonths;} public void setWarrantyMonths(int v){if(v<0)throw new IllegalArgumentException("Bảo hành phải >= 0.");warrantyMonths=v;}
    @Override public void displayInfo(){System.out.printf("%s | Hãng: %s | Bảo hành: %d tháng%n",this,brand,warrantyMonths);}
    @Override public String getCategory(){return "Electronics";} @Override public double calculateDiscount(){return getPrice()*0.10;}
}
