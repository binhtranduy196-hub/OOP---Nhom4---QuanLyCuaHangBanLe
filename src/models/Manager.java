
// Khai báo package chứa lớp này.
package models;
// Import lớp/thư viện cần sử dụng.
import java.util.*;
// Khai báo lớp cụ thể của hệ thống.
public class Manager extends Employee {
    // Khai báo thuộc tính private và final; danh sách/tham chiếu được gán một lần.
    private final List<Staff> staffList=new ArrayList<>();
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Manager(){
        this("QL000","Quản lý","0000000000","Manager");
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Manager(String id,String name,String phone,String position){
        super(id,name,phone,position);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public List<Staff> getStaffList(){
        return Collections.unmodifiableList(staffList);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addStaff(Staff s){
        if(s==null)throw new IllegalArgumentException("Nhân viên không được null.");
        if(!staffList.contains(s))staffList.add(s);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void addStaff(Staff... ss){
        if(ss==null)throw new IllegalArgumentException("Danh sách nhân viên không được null.");
        for(Staff s:ss)addStaff(s);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void manageStaff(){
        System.out.println("Quản lý "+getEmployeeName()+" đang quản lý "+staffList.size()+" nhân viên.");
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public void work(){
        System.out.println(getEmployeeName()+" đang quản lý ca và nhân viên.");
    }
// Đóng khối lệnh hiện tại.
}
