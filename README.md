# Quản lý cửa hàng bán lẻ - OOP - Nhóm 4

Project Java bám theo sơ đồ lớp đã chốt, 
## Cây kế thừa
- `Product` (abstract)
  - `Food`
  - `Electronics`
  - `Clothing`
- `Employee` 
  - `Manager`
  - `Staff`

## Interface
- `Sellable`
- `Discountable` (có `default method`)

## Quan hệ chính
- **Inheritance:** Product -> Food/Electronics/Clothing.
- **Inheritance:** Employee -> Manager/Staff.
- **Aggregation:** Store quản lý nhiều Product.
- **Aggregation:** Store quản lý nhiều Employee.
- **Aggregation:** Store quản lý nhiều Order.
- **Composition:** Order chứa các OrderItem.
- **Association:** Order liên kết với Employee tính tiền và Manager phụ trách.
- **Association:** Manager manages Staff.

## Chức năng chính
1. Thêm sản phẩm.
2. Sửa sản phẩm.
3. Xóa sản phẩm.
4. Tìm kiếm sản phẩm.
5. Tạo đơn và thanh toán.
6. Báo cáo doanh thu.
7. Báo cáo tồn kho.

## Kỹ thuật OOP
- Encapsulation: thuộc tính `private`, getter/setter.
- Validation trong setter và phương thức nghiệp vụ.
- Abstraction: `Product` là abstract class.
- Inheritance: 2 cây kế thừa.
- Polymorphism: xử lý nhiều loại Product bằng `List<Product>`.
- Interface: `Sellable`, `Discountable`.
- Overriding: displayInfo(), getCategory(), toString(), equals(), work().
- Overloading: constructor và `addProduct()` / `addStaff()`.
- Composition: Order tạo và sở hữu OrderItem.
- Static/final: hằng trạng thái đơn hàng và hằng tiêu đề.
- Input an toàn: kiểm tra dữ liệu nhập, bắt lỗi nghiệp vụ, không để chương trình crash khi nhập sai.

## Thanh toán
Khi khách hàng thanh toán, hóa đơn hiển thị:
- Nhân viên tính tiền.
- Quản lý phụ trách.
- Danh sách sản phẩm.
- Tổng tiền.

## Báo cáo
- Báo cáo doanh thu.
- Báo cáo tồn kho.

## Chạy chương trình
JDK 17+:

```bash
javac -encoding UTF-8 -d out src/Main.java src/helper/*.java src/models/*.java src/services/*.java
java -cp out Main
```

## Git commit
Lịch sử Git được tổ chức theo từng nhóm chức năng để dễ trình bày đồ án:
1. Tạo interface và abstract model.
2. Xây dựng Product và các lớp con.
3. Xây dựng Employee, Manager, Staff.
4. Xây dựng Customer, Order, OrderItem.
5. Xây dựng Store và CRUD sản phẩm.
6. Bổ sung thanh toán và liên kết nhân viên/quản lý.
7. Bổ sung báo cáo.
8. Hoàn thiện kiểm tra input và menu.
9. Loại bỏ nghiệp vụ Shift theo thiết kế cuối cùng.

## Danh sách thành viên gồm có:
1. Trần Duy Binh(C) | 2603ITA0021
2. Đặng Trần Minh   | 2603ITA0028
3. Dương Công Khánh | 2603ITA0020 