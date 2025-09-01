# ----- Giai đoạn 1: Build -----
# Sử dụng một image Maven hợp lệ và đang tồn tại
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy file pom.xml trước để tận dụng Docker cache
COPY pom.xml .

# Tải tất cả các thư viện cần thiết
RUN mvn dependency:go-offline

# Copy toàn bộ mã nguồn. Maven sẽ tự tìm thư mục webapp (web)
COPY src ./src

# Build dự án thành file .war.
# Maven sẽ tự động gói thư mục webapp vào file .war
RUN mvn clean package -DskipTests


# ----- Giai đoạn 2: Run -----
# Giữ nguyên image Tomcat
FROM tomcat:9.0-jdk17-temurin

# Dọn dẹp các ứng dụng mặc định
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war đã được build từ giai đoạn 1 vào thư mục webapps của Tomcat
# Đổi tên thành ROOT.war để ứng dụng chạy ở thư mục gốc (/)
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war