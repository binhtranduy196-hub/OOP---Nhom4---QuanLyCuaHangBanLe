package retailstore;
public class Staff extends Employee {
    private String skill;
    public Staff(){this("NV000","Nhân viên","0000000000","Staff","Bán hàng");}
    public Staff(String id,String name,String phone,String position,String skill){super(id,name,phone,position);setSkill(skill);}
    public Staff(Staff o){this(o.getEmployeeId(),o.getEmployeeName(),o.getPhone(),o.getPosition(),o.skill);}
    public String getSkill(){return skill;} public void setSkill(String v){if(v==null||v.isBlank())throw new IllegalArgumentException("Kỹ năng không được trống.");skill=v.trim();}
    @Override public void work(){System.out.println(getEmployeeName()+" đang thực hiện bán hàng.");}
    public void sellProduct(){System.out.println(getEmployeeName()+" đang hỗ trợ khách hàng.");}
}
