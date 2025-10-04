#!/bin/sh
# File này sẽ được Tomcat trên Render thực thi khi khởi động

# Chuyển các biến môi trường (do Render cung cấp) thành các System Properties của Java
# Tomcat sẽ tự động lấy các biến trong CATALINA_OPTS và thêm vào lệnh khởi động Java
export CATALINA_OPTS="$CATALINA_OPTS -Ddb.url=$DATABASE_URL"
export CATALINA_OPTS="$CATALINA_OPTS -Ddb.user=$DATABASE_USER"
export CATALINA_OPTS="$CATALINA_OPTS -Ddb.password=$DATABASE_PASSWORD"
export CATALINA_OPTS="$CATALINA_OPTS -Declipselink.ddl=validate"