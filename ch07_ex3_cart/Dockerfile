# ================= Giai đoạn 1: Builder (Dùng Maven để đóng gói) =================
# Sử dụng một image có sẵn Maven và JDK 17 (giống trong pom.xml của bạn)
FROM maven:3.9-eclipse-temurin-17 AS builder

# Thiết lập thư mục làm việc bên trong image
WORKDIR /app

# Copy file pom.xml trước để tận dụng Docker cache layer
# Nếu các thư viện không thay đổi, bước này sẽ không phải chạy lại, giúp build nhanh hơn
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy toàn bộ mã nguồn còn lại
COPY src ./src

# Chạy lệnh build của Maven để tạo ra file .war
# -DskipTests để bỏ qua việc chạy test, giúp build nhanh hơn khi deploy
RUN mvn clean package -DskipTests


# ================= Giai đoạn 2: Runner (Chạy ứng dụng trên Tomcat) =================
# Sử dụng một image Tomcat 9 chính thức với JDK 17, phiên bản slim rất nhẹ
FROM tomcat:9.0-jdk17-temurin

# Xóa các ứng dụng mặc định của Tomcat để image gọn nhẹ hơn
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war đã được build ở giai đoạn 1 vào thư mục webapps của Tomcat
# Tên file .war được lấy từ <finalName> trong pom.xml
# Đổi tên thành ROOT.war để ứng dụng chạy ngay tại đường dẫn gốc (vd: https://your-app.onrender.com/)
# thay vì (https://your-app.onrender.com/ch07_ex3_cart/)
COPY --from=builder /app/target/ch07_ex3_cart.war /usr/local/tomcat/webapps/ROOT.war

# Port mặc định của Tomcat là 8080, Render sẽ tự động nhận diện port này
EXPOSE 8080

# Lệnh mặc định của image Tomcat đã là "catalina.sh run", nên không cần thêm CMD