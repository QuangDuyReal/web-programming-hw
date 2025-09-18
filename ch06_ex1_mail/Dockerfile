# Giai đoạn 1: Build bằng Maven
FROM maven:3.9.6-eclipse-temurin-11 AS build
WORKDIR /app

# Copy toàn bộ source code vào container build
COPY pom.xml .
COPY src ./src

# Build file WAR (bỏ test cho nhanh)
RUN mvn clean package -DskipTests

# Giai đoạn 2: Chạy trên Tomcat 9
FROM tomcat:9.0-jdk11-temurin

# Xóa webapps mặc định của Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR đã build sang Tomcat, đổi tên thành ROOT.war để chạy ở "/"
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
