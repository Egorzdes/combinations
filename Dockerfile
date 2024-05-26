
FROM maven:3.8.1-openjdk-11 AS build
WORKDIR /app


COPY . .


RUN mvn clean package -DskipTests


FROM openjdk:11-jre-slim
WORKDIR /app

COPY --from=build /app/target/yourapp.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]