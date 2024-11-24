# Базовый образ с OpenJDK
FROM openjdk:11-jdk-slim

# Установить рабочую директорию
WORKDIR /app

# Копировать JAR-файл с зависимостями в контейнер
COPY target/proj-0.0.1-SNAPSHOT-jar-with-dependencies.jar app.jar

# Открыть порт приложения
EXPOSE 8080

# Запустить приложение
CMD ["java", "-jar", "app.jar"]
