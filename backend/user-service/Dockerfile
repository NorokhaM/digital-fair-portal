FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn -B -DskipTests clean package

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "user-service.jar"]