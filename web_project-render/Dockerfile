# Giai đoạn 1: Build project Maven
# Sử dụng image Maven chính thức với Java 8 để build code.
FROM maven:3.8-openjdk-8 AS build

# Đặt thư mục làm việc
WORKDIR /app

# Copy file pom.xml để tận dụng cache
COPY pom.xml .

# Tải dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build project, bỏ qua tests
RUN mvn clean package -DskipTests


# Giai đoạn 2: Tạo image cuối cùng để chạy
# Sử dụng image Tomcat nhẹ
FROM tomcat:9.0-jre8-slim

# Xóa các ứng dụng mặc định
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war đã build từ giai đoạn trước vào thư mục webapps của Tomcat.
# Đổi tên thành ROOT.war để chạy ở URL gốc.
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Lệnh để khởi động Tomcat
CMD ["catalina.sh", "run"]