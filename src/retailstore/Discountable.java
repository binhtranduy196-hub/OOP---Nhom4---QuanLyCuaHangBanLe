package retailstore;
public interface Discountable {
    double calculateDiscount();
    default String getDiscountInfo() { return "Sản phẩm có hỗ trợ giảm giá."; }
}
