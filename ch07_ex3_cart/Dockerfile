# Sử dụng image chính thức của Tomcat 9 với JDK 11 (phiên bản phổ biến và ổn định)
FROM tomcat:9.0-jdk11-temurin

# Xóa các ứng dụng web mặc định của Tomcat để dọn dẹp
RUN rm -rf /usr/local/tomcat/webapps/*

# Thay thế 'your-app.war' bằng tên file .war thực tế của bạn
# File .war này cần nằm trong cùng thư mục với Dockerfile hoặc bạn cần chỉ đúng đường dẫn
# Việc đổi tên thành ROOT.war giúp ứng dụng chạy tại địa chỉ gốc (ví dụ: http://localhost:8080/)
COPY target/ch07_ex3_cart.war /usr/local/tomcat/webapps/ROOT.war

# Cổng mặc định mà Tomcat lắng nghe
EXPOSE 8080

# Lệnh để khởi động Tomcat server khi container chạy
CMD ["catalina.sh", "run"]