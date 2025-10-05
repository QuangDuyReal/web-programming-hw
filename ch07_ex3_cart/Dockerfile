# ----- GIAI ĐOẠN 1: BUILD PROJECT VỚI MAVEN (SỬ DỤNG JDK 17) -----
# Đã thay đổi image này để sử dụng JDK 17
FROM maven:3-eclipse-temurin-17 AS builder

# Tạo thư mục làm việc trong image
WORKDIR /app

# Sao chép toàn bộ source code của bạn vào thư mục /app
COPY . .

# Chạy lệnh Maven để build và tạo ra file .war trong thư mục /app/target
RUN mvn clean package


# ----- GIAI ĐOẠN 2: TẠO IMAGE TOMCAT CUỐI CÙNG -----
# Giữ nguyên image Tomcat này vì nó tương thích tốt
FROM tomcat:9.0-jdk17-temurin

# Dọn dẹp các ứng dụng mặc định của Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Sao chép file .war đã được build ở GIAI ĐOẠN 1 vào thư mục webapps của Tomcat
COPY --from=builder /app/target/ch07_ex3_cart.war /usr/local/tomcat/webapps/ROOT.war

# Cổng mặc định
EXPOSE 8080

# Lệnh khởi động Tomcat
CMD ["catalina.sh", "run"]