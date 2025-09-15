# =================================================================
# GIAI ĐOẠN 1: BUILD MAVEN PROJECT
# Sử dụng một image có sẵn Maven và Java 17
# AS build -> đặt tên cho giai đoạn này là "build"
# =================================================================
FROM maven:3.9-eclipse-temurin-17 AS build

# TĂNG BỘ NHỚ CHO MAVEN LÊN 1024MB (1GB)
ENV MAVEN_OPTS="-Xmx1024m"

# Tạo một thư mục làm việc bên trong image
WORKDIR /app

# Copy các file pom.xml vào trước để tận dụng cache của Docker
COPY pom.xml .
COPY ch07_ex1_down/pom.xml ./ch07_ex1_down/
COPY musicStore/pom.xml ./musicStore/

# Tải tất cả dependency về
RUN mvn dependency:go-offline

# Copy toàn bộ mã nguồn vào
COPY ch07_ex1_down/src ./ch07_ex1_down/src
COPY musicStore/src ./musicStore/src

# Chạy lệnh build để tạo ra các file .war
# -DskipTests -> Bỏ qua việc chạy test để build nhanh hơn
RUN mvn clean package -DskipTests


# =================================================================
# GIAI ĐOẠN 2: TẠO MÔI TRƯỜNG CHẠY TOMCAT
# Sử dụng một image Tomcat 9 chính thức chạy trên Java 17
# =================================================================
FROM tomcat:9.0-jdk17-temurin

# Xóa các ứng dụng mặc định của Tomcat để image nhẹ hơn
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war đã được build ở giai đoạn 1 vào thư mục webapps của Tomcat
# --from=build -> chỉ định lấy file từ giai đoạn "build" ở trên
# Đổi tên file war thành ROOT.war để nó chạy ở đường dẫn gốc "/"
COPY --from=build /app/ch07_ex1_down/target/ch07_ex1_down.war /usr/local/tomcat/webapps/ROOT.war

# Lệnh để khởi động server Tomcat khi container chạy
CMD ["catalina.sh", "run"]