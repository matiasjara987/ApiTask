FROM openjdk:21-jdk-slim


RUN apt-get update && apt-get install -y maven

WORKDIR /app


COPY . /app


RUN mvn clean install


EXPOSE 8080

CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]