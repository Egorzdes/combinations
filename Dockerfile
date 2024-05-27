# Используем образ OpenJDK 11
FROM openjdk:11-jre-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файл из локальной директории в образ
COPY target/proj-0.0.1-SNAPSHOT.jar /app/proj-0.0.1-SNAPSHOT.jar

EXPOSE 9080

# Команда для запуска приложения в контейнере
CMD ["java", "-jar", "proj-0.0.1-SNAPSHOT.jar"]
