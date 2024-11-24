# Базовый образ с OpenJDK
FROM openjdk:11-jdk-slim

# Установить рабочую директорию
WORKDIR /app

# Копировать JAR-файл в контейнер
COPY target/app.jar app.jar

# Открыть порт приложения
EXPOSE 8080

# Запустить приложение
CMD ["java", "-jar", "app.jar"]
