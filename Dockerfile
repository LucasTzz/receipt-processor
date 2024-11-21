FROM openjdk:17-jdk-slim

WORKDIR /app

COPY receiptProcessor.jar receiptProcessor.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "receiptProcessor.jar"]