
# Убедитесь, что базовый образ установлен правильно
FROM maven:3.8.7-openjdk-17-slim as builder

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]
