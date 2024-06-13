FROM ubuntu:latest
LABEL authors="Radek"

FROM openjdk:11-jre-slim

WORKDIR /app

COPY build/libs/backend-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

ENTRYPOINT ["top", "-b"]