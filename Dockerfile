# Giai đoạn 1: Build ứng dụng bằng Maven
# Sửa lỗi: Sử dụng một image tag chính xác tồn tại trên Docker Hub
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Thiết lập thư mục làm việc bên trong container
WORKDIR /app

# Copy file pom.xml trước để tận dụng Docker layer caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy toàn bộ source code của bạn vào
COPY src ./src

# Chạy lệnh build của Maven để tạo ra file .war
RUN mvn clean package -DskipTests


# Giai đoạn 2: Tạo image chạy ứng dụng (runtime)
# Giai đoạn này không có lỗi và được giữ nguyên
FROM tomcat:9.0-jdk17-temurin

# Xóa các webapp mặc định của Tomcat để dọn dẹp
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war đã được build từ giai đoạn "builder" vào thư mục webapps của Tomcat
COPY --from=builder /app/target/port_black.war /usr/local/tomcat/webapps/ROOT.war

# Port mặc định của Tomcat là 8080
EXPOSE 8080