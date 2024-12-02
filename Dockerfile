# Используем образ с OpenJDK 17
FROM openjdk:17-jdk

# Устанавливаем утилиты, включая apt-get и Maven
RUN apt-get update && apt-get install -y maven

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем pom.xml в контейнер
COPY pom.xml /app/

# Загружаем зависимости Maven
RUN mvn dependency:go-offline

# Копируем JAR-файл в контейнер
COPY target/proj-0.0.1-SNAPSHOT.jar /app/proj-0.0.1-SNAPSHOT.jar

# Указываем команду для запуска приложения
CMD ["java", "-jar", "/app/proj-0.0.1-SNAPSHOT.jar"]
