package retailstore;
import java.util.Objects;
public abstract class Employee {
    private String employeeId,employeeName,phone,position;
    public Employee(){this("NV000","Nhân viên","0000000000","Staff");}
    public Employee(String id,String name,String phone,String position){setEmployeeId(id);setEmployeeName(name);setPhone(phone);setPosition(position);}
    public String getEmployeeId(){return employeeId;} public void setEmployeeId(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Mã nhân viên không được trống.");employeeId=v.trim();}
    public String getEmployeeName(){return employeeName;} public void setEmployeeName(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Tên nhân viên không được trống.");employeeName=v.trim();}
    public String getPhone(){return phone;} public void setPhone(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("SĐT không được trống.");phone=v.trim();}
    public String getPosition(){return position;} public void setPosition(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Chức vụ không được trống.");position=v.trim();}
    public abstract void work();
    @Override public String toString(){return String.format("[%s] %s | SĐT: %s | Chức vụ: %s",employeeId,employeeName,phone,position);}
    @Override public boolean equals(Object o){return o instanceof Employee e && Objects.equals(employeeId,e.employeeId);} @Override public int hashCode(){return Objects.hash(employeeId);}
}
