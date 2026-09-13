package retailstore;
public class Clothing extends Product {
    private String size; private String color;
    public Clothing(){this("C000","Quần áo",0,0,"M","Chưa rõ");}
    public Clothing(String id,String name,double price,int quantity,String size,String color){super(id,name,price,quantity);setSize(size);setColor(color);}
    public Clothing(Clothing o){this(o.getId(),o.getName(),o.getPrice(),o.getQuantity(),o.size,o.color);}
    public String getSize(){return size;} public void setSize(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Kích thước không được trống.");size=v.trim();}
    public String getColor(){return color;} public void setColor(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Màu sắc không được trống.");color=v.trim();}
    @Override public void displayInfo(){System.out.printf("%s | Size: %s | Màu: %s%n",this,size,color);}
    @Override public String getCategory(){return "Clothing";} @Override public double calculateDiscount(){return getPrice()*0.15;}
}
