package retailstore;
import java.util.Objects;
public abstract class Product implements Sellable, Discountable {
    private String id; private String name; private double price; private int quantity;
    protected static final double MIN_PRICE = 0.0; protected static final int MIN_QUANTITY = 0;
    public Product(){ this("P000","Chưa đặt tên",0,0); }
    public Product(String id,String name,double price,int quantity){ setId(id);setName(name);setPrice(price);setQuantity(quantity); }
    public Product(Product other){ this(other.id,other.name,other.price,other.quantity); }
    public String getId(){return id;} public void setId(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Mã sản phẩm không được trống.");id=v.trim();}
    public String getName(){return name;} public void setName(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Tên sản phẩm không được trống.");name=v.trim();}
    public double getPrice(){return price;} public void setPrice(double v){if(Double.isNaN(v)||Double.isInfinite(v)||v<0)throw new IllegalArgumentException("Giá phải >= 0.");price=v;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){if(v<0)throw new IllegalArgumentException("Tồn kho phải >= 0.");quantity=v;}
    public void increaseQuantity(int v){if(v<=0)throw new IllegalArgumentException("Số lượng nhập thêm phải > 0.");quantity+=v;}
    public void decreaseQuantity(int v){if(v<=0)throw new IllegalArgumentException("Số lượng xuất phải > 0.");if(v>quantity)throw new IllegalArgumentException("Không đủ tồn kho.");quantity-=v;}
    @Override public double calculatePrice(){return price;}
    @Override public void showSaleInfo(){System.out.printf("%s - %s: %,.0f VNĐ%n",id,name,calculatePrice());}
    @Override public double calculateDiscount(){return 0;}
    @Override public String getDiscountInfo(){return "Giảm giá: "+String.format("%,.0f",calculateDiscount())+" VNĐ";}
    public abstract void displayInfo(); public abstract String getCategory();
    @Override public String toString(){return String.format("[%s] %s | Giá: %,.0f | Tồn: %d | Loại: %s",id,name,price,quantity,getCategory());}
    @Override public boolean equals(Object o){return o instanceof Product p && Objects.equals(id,p.id);}
    @Override public int hashCode(){return Objects.hash(id);}
}
