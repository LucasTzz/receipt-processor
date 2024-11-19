FROM arm64v8/openjdk:17-ea-16-jdk

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "receiptProcessor.jar"]