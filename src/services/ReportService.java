
// Khai báo package chứa lớp này.
package services;
import models.Order;
import models.Product;
import java.time.LocalDate; import java.util.*;
// Khai báo lớp cụ thể của hệ thống.
public class ReportService {
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public double calculateRevenue(List<Order> os){
        double r=0;
        for(Order o:os)
            if(Order.PAID.equals(o.getStatus()))
                r+=o.calculateTotal();
            return r;
        }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public double calculateRevenue(List<Order> os,LocalDate from,LocalDate to){
        if(from==null||to==null||from.isAfter(to))throw new IllegalArgumentException("Khoảng ngày không hợp lệ.");
        double r=0;
        for(Order o:os)
            if(Order.PAID.equals(o.getStatus())&&!o.getDate().isBefore(from)&&!o.getDate().isAfter(to))
                r+=o.calculateTotal();
        return r;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void printRevenueReport(List<Order> os){
        System.out.println("\\n===== BÁO CÁO DOANH THU =====");
        System.out.printf("Tổng doanh thu: %,.0f VNĐ%n",calculateRevenue(os));
        System.out.println("Số đơn đã thanh toán: "+os.stream().filter(o->Order.PAID.equals(o.getStatus())).count());
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void printInventoryReport(List<Product> ps){
        System.out.println("\\n===== BÁO CÁO TỒN KHO =====");
        int q=0;
        double value=0;
        Map<String,Integer> m=new HashMap<>();
        for(Product p:ps){
            q+=p.getQuantity();
            value+=p.getQuantity()*p.getPrice();
            m.merge(p.getCategory(),p.getQuantity(),Integer::sum);
        }
        System.out.println("Tổng số lượng tồn: "+q);
        System.out.printf("Giá trị tồn kho: %,.0f VNĐ%n",value);
        m.forEach((k,v)->System.out.println("- "+k+": "+v));
    }
// Đóng khối lệnh hiện tại.
}
