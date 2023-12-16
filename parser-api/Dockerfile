FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/parser-api-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "/app/parser-api-1.0-SNAPSHOT.jar"]