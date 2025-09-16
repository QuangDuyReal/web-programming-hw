# ----- GIAI ĐOẠN 1: BUILD PROJECT VỚI MAVEN -----
# Sử dụng image có sẵn Maven và JDK 11 để làm "môi trường build"
FROM maven:3.8-openjdk-11 AS builder

# Tạo thư mục làm việc trong image
WORKDIR /app

# Sao chép toàn bộ source code của bạn vào thư mục /app
COPY . .

# Chạy lệnh Maven để build và tạo ra file .war trong thư mục /app/target
RUN mvn clean package


# ----- GIAI ĐOẠN 2: TẠO IMAGE TOMCAT CUỐI CÙNG -----
# Sử dụng image Tomcat 9 làm image cuối cùng để chạy ứng dụng
FROM tomcat:9.0-jdk11-temurin

# Dọn dẹp các ứng dụng mặc định của Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Sao chép file .war đã được build ở GIAI ĐOẠN 1 vào thư mục webapps của Tomcat
# Docker sẽ tự động lấy file từ image "builder" ở trên
COPY --from=builder /app/target/ch07_ex3_cart.war /usr/local/tomcat/webapps/ROOT.war

# Cổng mặc định
EXPOSE 8080

# Lệnh khởi động Tomcat
CMD ["catalina.sh", "run"]