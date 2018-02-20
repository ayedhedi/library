FROM openjdk:8-jre-alpine
COPY ./target/apigateway-0.0.1-SNAPSHOT.jar /usr/src/apigateway/
WORKDIR /usr/src/apigateway/
EXPOSE 8000
CMD ["java", "-jar", "apigateway-0.0.1-SNAPSHOT.jar"]