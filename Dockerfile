
# Убедитесь, что базовый образ установлен правильно
FROM maven:3.8.4-openjdk-17-slim as builder

# Установите рабочую директорию
WORKDIR /app

# Копировать JAR-файл в контейнер
COPY target/proj-0.0.1-SNAPSHOT-jar-with-dependencies.jar app.jar
# Копируйте файл pom.xml и исходные файлы проекта
COPY pom.xml /app/
COPY src /app/src
# Выполните сборку
RUN mvn clean package
# Переключитесь на легкий образ для запуска
FROM openjdk:17-jdk-slim
COPY --from=builder /app/target/combinations-0.0.1-SNAPSHOT.jar /app/app.jar

# Открыть порт приложения
EXPOSE 8081
# Установите точку входа
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]
