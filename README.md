# loyaltyCard-test

home test of sapo

a. Viết API cho phép chỉnh sửa cấu hình tích điểm lưu trữ vào database

- ConfigController.java (/api-v1/configs/{id}) - method: PUT
- Sử dụng H2 Database (http://localhost:8080/h2-console)

b. Xử lý tích điểm vào thẻ cho khách hàng dựa trên giao dịch, thay đổi thông tin hạng thẻ của khách hàng tương ứng

- LoyaltyCardController.java (/api-v1/loyaltyCard) - method: POST
- Đối với điểm và tiền giao dịch của thẻ: Em lấy tất cả dữ liệu trong bảng Loyalty_Card, sau đó dựa vào id của từng thẻ để lấy dữ liệu giao dịch trong bảng transaction
rồi cộng điểm và số tiền phải trả của từng giao dịch của thẻ đó cho từng bản ghi trong bản Loyalty_Card
- Đối với thông tin hạng thẻ: Sau khi đã có tổng số tiền thanh toán mới nhất từ các giao dịch cập nhật cho từng thẻ thì em lấy tất cả bản
ghi trong bảng Loyalty_Card_Type để so sánh với tổng số tiền để lấy id của loại thẻ cập nhật cho từng thẻ khách hàng.

c. Unit test

- Test các hàm xử lý ở service

d.1 Nếu giao dịch được tổng hợp từ các hệ thống khác và định kỳ được tải lên hệ thống tích điểm, thì xử lý như thế nào trong trường hợp cấu hình quy đổi điểm bị thay đổi giữa các lần giao dịch của khách hàng?

- Theo em thì bảng cấu hình cần lưu lại các bản ghi cũ khi chưa chỉnh sửa (có thể xóa sau)
- Khi tính toán cộng điểm cho khác hàng cần dựa vào thời gian chỉnh sửa của cấu hình quy đổi điểm và thời gian của các giao dịch.
