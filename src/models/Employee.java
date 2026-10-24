
// Khai báo package chứa lớp này.
package models;
// Import lớp/thư viện cần sử dụng.
import java.util.Objects;
// Khai báo lớp trừu tượng, dùng làm lớp cha và không tạo đối tượng trực tiếp.
public abstract class Employee {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String employeeId,employeeName,phone,position;
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Employee(){
        this("NV000","Nhân viên","0000000000","Staff");
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Employee(String id,String name,String phone,String position){
        setEmployeeId(id);
        setEmployeeName(name);
        setPhone(phone);
        setPosition(position);
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getEmployeeId(){
        return employeeId;
    } 
    public void setEmployeeId(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Mã nhân viên không được trống.");
        employeeId=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getEmployeeName(){
        return employeeName;
    } 
    public void setEmployeeName(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Tên nhân viên không được trống.");
        employeeName=v.trim();
    }   
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getPhone(){
        return phone;
    } 
    public void setPhone(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("SĐT không được trống.");
        phone=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getPosition(){
        return position;
    } 
    public void setPosition(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Chức vụ không được trống.");
        position=v.trim();
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public abstract void work();
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override public String toString(){
        return String.format("[%s] %s | SĐT: %s | Chức vụ: %s",employeeId,employeeName,phone,position);
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public boolean equals(Object o){
        return o instanceof Employee e && Objects.equals(employeeId,e.employeeId);
    } 
    @Override 
    public int hashCode(){
        return Objects.hash(employeeId);
    }
// Đóng khối lệnh hiện tại.
}
