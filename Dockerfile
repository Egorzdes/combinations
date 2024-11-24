FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/combinations-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
