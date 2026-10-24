
// Khai báo package chứa lớp này.
package models;
// Khai báo lớp cụ thể của hệ thống.
public class Staff extends Employee {
    // Khai báo thuộc tính private để đảm bảo đóng gói (encapsulation).
    private String skill;
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Staff(){this("NV000","Nhân viên","0000000000","Staff","Bán hàng");     
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Staff(String id,String name,String phone,String position,String skill){
        super(id,name,phone,position);setSkill(skill);
    }
    // Khai báo thành phần public có thể được truy cập từ bên ngoài lớp.
    public Staff(Staff o){
        this(o.getEmployeeId(),o.getEmployeeName(),o.getPhone(),o.getPosition(),o.skill);

    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String getSkill(){
        return skill;
    } 
    public void setSkill(String v){
        if(v==null||v.isBlank())throw new IllegalArgumentException("Kỹ năng không được trống.");skill=v.trim();
    }
    // Đánh dấu phương thức đang ghi đè phương thức của lớp cha hoặc interface.
    @Override 
    public void work(){
        System.out.println(getEmployeeName()+" đang thực hiện bán hàng.");
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public void sellProduct(){
        System.out.println(getEmployeeName()+" đang hỗ trợ khách hàng.");
    }
// Đóng khối lệnh hiện tại.
}
