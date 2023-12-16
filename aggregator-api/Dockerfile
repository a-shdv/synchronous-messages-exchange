FROM openjdk:17-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY aggregator-api-1.0-SNAPSHOT.jar /app

CMD ["java", "-jar", "/app/aggregator-api-1.0-SNAPSHOT.jar"]