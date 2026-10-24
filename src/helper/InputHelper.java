
// Khai báo package chứa lớp này.
package helper;
// Import lớp/thư viện cần sử dụng.
import java.time.LocalDate; 
import java.time.format.DateTimeParseException; 
import java.util.Scanner;
// Khai báo lớp cụ thể của hệ thống.
public class InputHelper {
    // Khai báo thuộc tính private và final; danh sách/tham chiếu được gán một lần.
    private final Scanner scanner; 
    public InputHelper(Scanner scanner){

        if(scanner==null)throw new IllegalArgumentException("Scanner không được null.");
        this.scanner=scanner;
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public String readRequiredString(String msg){
        while(true){
            System.out.print(msg);
            String v=scanner.nextLine().trim();
            if(!v.isBlank())return v;
            System.out.println("Dữ liệu không được để trống. Nhập lại.");}
        }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public int readInt(String msg,int min,int max){
        while(true){
            System.out.print(msg);
            try{
                int v=Integer.parseInt(scanner.nextLine().trim());
                if(v<min||v>max){
                    System.out.printf("Nhập số từ %d đến %d.%n",min,max);
                    continue;
                }
                return v;
            }catch(NumberFormatException e){
                System.out.println("Phải nhập số nguyên hợp lệ.");
            }
        }
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public double readDouble(String msg,double min){
        while(true){
            System.out.print(msg);
            try{
                double v=Double.parseDouble(scanner.nextLine().trim().replace(',','.'));
                if(v<min||Double.isNaN(v)||Double.isInfinite(v)){
                    System.out.println("Giá trị không hợp lệ.");
                    continue;
                }
                return v;
            }catch(NumberFormatException e){
                System.out.println("Phải nhập số thực hợp lệ.");
            }
        }
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public LocalDate readDate(String msg){
        while(true){
            System.out.print(msg+" (yyyy-MM-dd): ");
            try{
                return LocalDate.parse(scanner.nextLine().trim());
            }catch(DateTimeParseException e){
                System.out.println("Ngày không hợp lệ. Ví dụ: 2026-09-13");
            }
        }
    }
    // Khai báo phương thức/constructor public để cung cấp chức năng cho đối tượng.
    public boolean confirm(String msg){
        while(true){
            String v=readRequiredString(msg+" (Y/N): ");
            if(v.equalsIgnoreCase("Y"))
                return true;
            if(v.equalsIgnoreCase("N"))
                return false;
            System.out.println("Chỉ nhập Y hoặc N.");
        }
    }
    //
    public void pause(){
        System.out.print("Nhấn Enter để tiếp tục...");scanner.nextLine();
    }
}
