# Этап сборки
FROM maven:3.8.4-openjdk-17-slim AS builder

# Устанавливаем рабочую директорию для Maven
WORKDIR /app

# Копируем POM файл и исходные файлы проекта
COPY pom.xml /app/
COPY src /app/src/

# Выполняем сборку проекта с Maven, пропуская тесты
RUN mvn clean package -DskipTests

# Этап для создания финального образа
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию в финальном образе
WORKDIR /app

# Копируем сгенерированный JAR файл из предыдущего этапа
COPY --from=builder /app/target/combinations-0.0.1-SNAPSHOT.jar /app/app.jar

# Открываем порт 8081 для приложения
EXPOSE 8081

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Устанавливаем CMD (эта команда будет выполняться по умолчанию, но может быть переопределена)
CMD ["java", "-jar", "/app/app.jar"]
