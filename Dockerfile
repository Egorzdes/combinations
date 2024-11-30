# Убедитесь, что базовый образ установлен правильно
FROM maven:3.8.4-openjdk-17-slim as builder

# Установите рабочую директорию
WORKDIR /app

# Копируйте файл pom.xml и исходные файлы проекта
COPY pom.xml /app/
COPY src /app/src

# Выполните сборку
RUN mvn clean package

# Переключитесь на легкий образ для запуска
FROM openjdk:17-jdk-slim
COPY --from=builder /app/target/combinations-0.0.1-SNAPSHOT.jar /app/app.jar

# Установите точку входа
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

