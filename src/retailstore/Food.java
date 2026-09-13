package retailstore;
import java.time.LocalDate;
public class Food extends Product {
    private LocalDate expiryDate; private String foodType;
    public Food(){this("F000","Thực phẩm",0,0,LocalDate.now(),"Khác");}
    public Food(String id,String name,double price,int quantity,LocalDate expiryDate,String foodType){super(id,name,price,quantity);setExpiryDate(expiryDate);setFoodType(foodType);}
    public Food(Food o){this(o.getId(),o.getName(),o.getPrice(),o.getQuantity(),o.expiryDate,o.foodType);}
    public LocalDate getExpiryDate(){return expiryDate;} public void setExpiryDate(LocalDate v){if(v==null)throw new IllegalArgumentException("HSD không được null.");expiryDate=v;}
    public String getFoodType(){return foodType;} public void setFoodType(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Loại thực phẩm không được trống.");foodType=v.trim();}
    @Override public void displayInfo(){System.out.printf("%s | HSD: %s | Loại: %s%n",this,expiryDate,foodType);}
    @Override public String getCategory(){return "Food";} @Override public double calculateDiscount(){return getPrice()*0.05;}
}
