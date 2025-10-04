# --- Stage 1: Build the application using Maven ---
# Sử dụng một image Maven chính thức để build file .war
# Đặt tên cho stage này là "build" để có thể tham chiếu sau này
FROM maven:3.8.5-openjdk-17 AS build

# Đặt thư mục làm việc bên trong container
WORKDIR /app

# Copy file pom.xml trước để tận dụng cache của Docker
# Nếu pom.xml không đổi, Docker sẽ không cần tải lại dependency
COPY pom.xml .

# Tải tất cả dependency về
RUN mvn dependency:go-offline

# Copy toàn bộ mã nguồn của project vào container
COPY src ./src

# Chạy lệnh build của Maven để tạo file .war
# -DskipTests để bỏ qua việc chạy unit test, giúp build nhanh hơn
RUN mvn package -DskipTests


# --- Stage 2: Build the final runtime image ---
# Sử dụng một image Tomcat chính thức, phiên bản tương thích với code của chúng ta
FROM tomcat:9.0-jdk17-corretto

# Xóa các ứng dụng web mặc định của Tomcat để image nhẹ hơn
RUN rm -rf /usr/local/tomcat/webapps/*

COPY setenv.sh /usr/local/tomcat/bin/

# Copy file .war đã được build ở Stage 1 vào thư mục webapps của Tomcat
# Docker sẽ tự động giải nén nó khi container khởi động
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war