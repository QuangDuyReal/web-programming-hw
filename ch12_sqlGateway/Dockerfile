# ----- STAGE 1: Build Stage -----
# Sử dụng một image Maven chính thức để build ứng dụng.
# Image này đã có sẵn JDK 11 và Maven.
FROM maven:3.8-openjdk-11 AS builder

# Thiết lập thư mục làm việc bên trong container
WORKDIR /app

# Copy file pom.xml trước để tận dụng Docker cache.
# Nếu file pom.xml không thay đổi, Docker sẽ không cần tải lại dependencies.
COPY pom.xml .

# Tải về tất cả các dependencies của dự án
RUN mvn dependency:go-offline

# Copy toàn bộ mã nguồn của dự án vào container
COPY src ./src

# Build ứng dụng, tạo ra file .war và bỏ qua các bài test
RUN mvn clean package -DskipTests


# ----- STAGE 2: Run Stage -----
# Sử dụng một image Tomcat chính thức, gọn nhẹ để chạy ứng dụng.
# Image này chỉ chứa JRE (Java Runtime Environment), đủ để chạy, giúp image nhẹ hơn.
FROM tomcat:9.0-jre11

# Xóa các ứng dụng mặc định của Tomcat để tiết kiệm dung lượng
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war đã được build từ Stage 1 vào thư mục webapps của Tomcat.
# Quan trọng: Đổi tên file .war thành ROOT.war.
# Điều này giúp ứng dụng của bạn chạy ở URL gốc (ví dụ: https://my-app.onrender.com/)
# thay vì (https://my-app.onrender.com/ch12_sqlGateway/)
COPY --from=builder /app/target/ch12_ex1_sqlGateway.war /usr/local/tomcat/webapps/ROOT.war

# Port mà Tomcat lắng nghe mặc định
EXPOSE 8080

# Lệnh để khởi động server Tomcat khi container chạy.
# Lệnh này đã được định nghĩa sẵn trong image Tomcat base, nên chúng ta không cần thêm.
# CMD ["catalina.sh", "run"]