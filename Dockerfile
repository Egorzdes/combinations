# Используем официальный образ с полным JDK 17 (с полным набором библиотек и инструментов)
FROM openjdk:17-jdk

# Создаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем только файл с зависимостями (если используете Maven) или непосредственно JAR-файл
# Важно: если вы используете Maven, вы можете сначала скопировать только pom.xml, чтобы кэшировать зависимости
COPY pom.xml /app/
RUN apt-get update && apt-get install -y maven  # Устанавливаем Maven (если нужно для сборки)
RUN mvn dependency:go-offline                 # Загружаем зависимости (если необходимо)

# Копируем сам JAR-файл в контейнер
COPY target/proj-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/proj-0.0.1-SNAPSHOT.jar

# Если ваше приложение использует порт, откройте его (например, 8080)
EXPOSE 8080

# Указываем команду для запуска JAR-файла
ENTRYPOINT ["java", "-jar", "proj-0.0.1-SNAPSHOT.jar"]
