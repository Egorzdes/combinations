# Используем образ с Maven
FROM maven:3.8.6

# Устанавливаем OpenJDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Копируем pom.xml и загружаем зависимости
COPY pom.xml /app/
WORKDIR /app
RUN mvn dependency:go-offline

# Копируем JAR файл
COPY target/proj-0.0.1-SNAPSHOT.jar /app/proj-0.0.1-SNAPSHOT.jar

# Указываем рабочую директорию
WORKDIR /app

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "proj-0.0.1-SNAPSHOT.jar"]
