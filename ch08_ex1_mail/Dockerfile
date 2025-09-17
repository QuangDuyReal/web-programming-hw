# ---------- Stage 1: Build Maven ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# copy source vào container
WORKDIR /app
COPY pom.xml .
COPY src ./src

# build ra file WAR
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run on Tomcat 9 ----------
FROM tomcat:9.0-jdk17-temurin

# Xoá các file sample của Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR từ stage build sang Tomcat
# (đặt tên ROOT.war để deploy trực tiếp ở /)
COPY --from=build /app/target/ch08_ex1_mail-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Mở port 8080 (Render sẽ map tới)
EXPOSE 8080

# Khởi chạy Tomcat
CMD ["catalina.sh", "run"]
