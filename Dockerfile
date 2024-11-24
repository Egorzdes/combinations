# Используем официальный образ OpenJDK как базовый
FROM openjdk:17-jdk-slim

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл JAR (собранный) в контейнер
COPY target/your-application-name.jar app.jar

# Указываем команду для запуска приложения
CMD ["java", "-jar", "app.jar"]

# Открываем порт, на котором работает приложение
EXPOSE 8080
