// Khai báo package chứa lớp này.
package services;
// Khai báo interface để định nghĩa nhóm hành vi mà lớp thực hiện.
public interface Discountable {
    // Khai báo biến cục bộ để lưu dữ liệu phục vụ xử lý.
    double calculateDiscount();
    // Xử lý trường hợp mặc định khi không khớp case.
    default String getDiscountInfo() { 
        return "Sản phẩm có hỗ trợ giảm giá.";
    }
// Đóng khối lệnh hiện tại.
}
