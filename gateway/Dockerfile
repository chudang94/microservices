FROM eclipse-temurin:21-jre-alpine
LABEL author="dangchu"

WORKDIR /app

# Copy file JAR đã build sẵn vào image
COPY /target/gateway-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]