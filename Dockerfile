FROM openjdk:17-jdk-slim
COPY target/proj-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/proj-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "proj-0.0.1-SNAPSHOT.jar"]
