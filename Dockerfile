# Stage 1: Сборка приложения с Maven
FROM maven:3.8.6-openjdk-17 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем pom.xml и загружаем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код и собираем приложение
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Запуск приложения с OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR файл из предыдущего этапа
COPY --from=build /app/target/proj-0.0.1-SNAPSHOT.jar /app/proj-0.0.1-SNAPSHOT.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "proj-0.0.1-SNAPSHOT.jar"]
