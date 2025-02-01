FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn -B -DskipTests clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/fair-service-0.0.1-SNAPSHOT.jar /app/fair-service.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar", "fair-service.jar"]