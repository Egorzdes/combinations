# Используем образ для сборки проекта
FROM maven:3.8.4-openjdk-17-slim AS builder

# Установить рабочую директорию для Maven
WORKDIR /app

# Копируем POM файл и исходники для Maven
COPY pom.xml /app/
COPY src /app/src/

# Собираем проект с помощью Maven
RUN mvn clean package -DskipTests

# Переключаемся на более легкий образ для запуска
FROM openjdk:17-jdk-slim

# Копируем артефакт из предыдущего слоя (сборка Maven)
COPY --from=builder /app/target/combinations-0.0.1-SNAPSHOT.jar /app/app.jar

# Открываем порт для приложения
EXPOSE 8081

# Устанавливаем точку входа для приложения
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Команда для запуска приложения
CMD ["java", "-jar", "/app/app.jar"]
