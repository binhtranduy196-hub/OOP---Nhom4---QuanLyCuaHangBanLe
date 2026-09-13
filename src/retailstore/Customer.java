package retailstore;
import java.util.*;
public class Customer {
    private String id,name,phone; private final List<Order> orders=new ArrayList<>();
    public Customer(){this("KH000","Khách hàng","0000000000");} public Customer(String id,String name,String phone){setId(id);setName(name);setPhone(phone);}
    public String getId(){return id;} public void setId(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Mã KH không được trống.");id=v.trim();}
    public String getName(){return name;} public void setName(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Tên KH không được trống.");name=v.trim();}
    public String getPhone(){return phone;} public void setPhone(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("SĐT không được trống.");phone=v.trim();}
    public void createOrder(Order o){if(o==null)throw new IllegalArgumentException("Đơn hàng không được null.");if(!orders.contains(o))orders.add(o);} public Order createOrder(String id){Order o=new Order(id,java.time.LocalDate.now(),Order.PENDING);createOrder(o);return o;}
    public List<Order> viewOrders(){return Collections.unmodifiableList(orders);}
    @Override public String toString(){return String.format("[%s] %s | SĐT: %s | Số đơn: %d",id,name,phone,orders.size());}
    @Override public boolean equals(Object o){return o instanceof Customer c&&Objects.equals(id,c.id);} @Override public int hashCode(){return Objects.hash(id);}
}
