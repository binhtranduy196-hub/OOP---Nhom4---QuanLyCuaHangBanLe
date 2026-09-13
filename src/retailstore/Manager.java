package retailstore;
import java.util.*;
public class Manager extends Employee {
    private final List<Staff> staffList=new ArrayList<>();
    public Manager(){this("QL000","Quản lý","0000000000","Manager");}
    public Manager(String id,String name,String phone,String position){super(id,name,phone,position);}
    public List<Staff> getStaffList(){return Collections.unmodifiableList(staffList);}
    public void addStaff(Staff s){if(s==null)throw new IllegalArgumentException("Nhân viên không được null.");if(!staffList.contains(s))staffList.add(s);}
    public void addStaff(Staff... ss){if(ss==null)throw new IllegalArgumentException("Danh sách nhân viên không được null.");for(Staff s:ss)addStaff(s);}
    public void manageStaff(){System.out.println("Quản lý "+getEmployeeName()+" đang quản lý "+staffList.size()+" nhân viên.");}
    @Override public void work(){System.out.println(getEmployeeName()+" đang quản lý ca và nhân viên.");}
}
