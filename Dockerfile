# Используем образ с OpenJDK 17 и Maven
FROM maven:3.8.6-openjdk-17

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем pom.xml в контейнер
COPY pom.xml /app/

# Загружаем зависимости Maven (если они еще не загружены)
RUN mvn dependency:go-offline

# Копируем JAR-файл в контейнер
COPY target/proj-0.0.1-SNAPSHOT.jar /app/proj-0.0.1-SNAPSHOT.jar

# Указываем команду для запуска приложения
CMD ["java", "-jar", "/app/proj-0.0.1-SNAPSHOT.jar"]
