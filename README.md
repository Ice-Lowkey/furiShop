furiShop
furiShop là một ứng dụng web bán hàng được xây dựng trên nền tảng Spring Boot với mô hình MVC (Model-View-Controller). Ứng dụng này cho phép người dùng duyệt qua các sản phẩm, thêm chúng vào giỏ hàng, và thực hiện các giao dịch mua bán một cách dễ dàng.

Mô hình MVC
furiShop áp dụng mô hình MVC để tách biệt các thành phần chính của ứng dụng:

Model: Chứa các lớp đại diện cho dữ liệu của ứng dụng, bao gồm các thực thể (entities) được ánh xạ với các bảng trong cơ sở dữ liệu.
View: Các trang JSP được sử dụng để hiển thị thông tin cho người dùng cuối. Các trang này được render dựa trên dữ liệu nhận từ Controller.
Controller: Xử lý các yêu cầu từ người dùng, tương tác với Model để lấy dữ liệu cần thiết, và trả về View tương ứng để hiển thị dữ liệu đó.
JPA và Hibernate
Dự án này sử dụng Java Persistence API (JPA) để quản lý dữ liệu liên tục trong ứng dụng. JPA cung cấp một cách tiếp cận mạnh mẽ và dễ sử dụng để làm việc với cơ sở dữ liệu mà không cần phải viết quá nhiều SQL thủ công.

Hibernate được sử dụng như một triển khai của JPA trong furiShop. Hibernate cung cấp các tính năng như lazy loading, caching, và xử lý quan hệ phức tạp giữa các thực thể, giúp cho việc quản lý dữ liệu trở nên hiệu quả hơn. Ngoài ra, Hibernate còn hỗ trợ tự động tạo bảng trong cơ sở dữ liệu dựa trên các lớp thực thể được khai báo trong ứng dụng.

Tính năng chính
Quản lý sản phẩm
Giỏ hàng và thanh toán
Quản lý người dùng và quyền truy cập
Giao diện quản trị với các tính năng nâng cao
