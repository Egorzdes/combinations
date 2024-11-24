# Базовый образ с OpenJDK 17
FROM openjdk:17-jdk-slim

# Установить рабочую директорию в контейнере
WORKDIR /app

# Копировать JAR-файл в контейнер
COPY target/proj-0.0.1-SNAPSHOT-jar-with-dependencies.jar app.jar

# Открыть порт приложения
EXPOSE 8081

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]
