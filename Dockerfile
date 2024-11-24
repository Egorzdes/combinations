# Базовый образ с установленным JDK 17
FROM openjdk:17-jdk-slim

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование файлов проекта в контейнер
COPY . .

# Установка Maven и сборка приложения
RUN apt-get update && apt-get install -y maven && mvn clean package

# Указываем порт, который будет использовать приложение
EXPOSE 8082

# Запуск приложения
CMD ["java", "-jar", "target/ваш-jar-файл.jar"]
