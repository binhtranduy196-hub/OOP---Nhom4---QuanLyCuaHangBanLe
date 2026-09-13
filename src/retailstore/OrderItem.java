package retailstore;
import java.util.Objects;
public class OrderItem {
    private int quantity; private double unitPrice; private final Product product;
    public OrderItem(){this(null,0,0);}
    public OrderItem(Product product,int quantity){this(product,quantity,product==null?0:product.getPrice());}
    public OrderItem(Product product,int quantity,double unitPrice){if(product==null)throw new IllegalArgumentException("Sản phẩm không được null.");if(quantity<=0)throw new IllegalArgumentException("Số lượng mua phải > 0.");if(unitPrice<0)throw new IllegalArgumentException("Đơn giá phải >= 0.");this.product=product;this.quantity=quantity;this.unitPrice=unitPrice;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){if(v<=0)throw new IllegalArgumentException("Số lượng mua phải > 0.");quantity=v;}
    public double getUnitPrice(){return unitPrice;} public void setUnitPrice(double v){if(v<0)throw new IllegalArgumentException("Đơn giá phải >= 0.");unitPrice=v;}
    public Product getProduct(){return product;} public double getSubtotal(){return quantity*unitPrice;}
    @Override public String toString(){return String.format("%s | SL: %d | Đơn giá: %,.0f | Thành tiền: %,.0f",product.getName(),quantity,unitPrice,getSubtotal());}
    @Override public boolean equals(Object o){return o instanceof OrderItem i&&Objects.equals(product,i.product);} @Override public int hashCode(){return Objects.hash(product);}
}
