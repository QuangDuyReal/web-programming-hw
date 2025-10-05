# Giai đoạn 1: Build ứng dụng bằng Maven
# Sử dụng một image chứa Maven và JDK 17 (giống môi trường của bạn) để build file .war
FROM maven:3.8-jdk-17-slim AS builder

# Thiết lập thư mục làm việc bên trong container
WORKDIR /app

# Copy file pom.xml trước để tận dụng Docker layer caching
# Nếu pom.xml không thay đổi, Docker sẽ không cần tải lại dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy toàn bộ source code của bạn vào
COPY src ./src

# Chạy lệnh build của Maven để tạo ra file .war
# -DskipTests để bỏ qua việc chạy test, giúp build nhanh hơn
RUN mvn clean package -DskipTests


# Giai đoạn 2: Tạo image chạy ứng dụng (runtime)
# Sử dụng image Tomcat 9 chính thức với JDK 17
FROM tomcat:9.0-jdk17-temurin

# Xóa các webapp mặc định của Tomcat để dọn dẹp
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war đã được build từ giai đoạn "builder" vào thư mục webapps của Tomcat
# QUAN TRỌNG: Đổi tên file port_black.war thành ROOT.war
# Điều này giúp ứng dụng của bạn chạy ngay tại URL gốc (ví dụ: my-app.onrender.com)
# thay vì phải truy cập (my-app.onrender.com/port_black)
COPY --from=builder /app/target/port_black.war /usr/local/tomcat/webapps/ROOT.war

# Port mặc định của Tomcat là 8080
EXPOSE 8080

# Lệnh mặc định của image Tomcat đã là `catalina.sh run` để khởi động server,
# nên chúng ta không cần thêm lệnh CMD ở đây.