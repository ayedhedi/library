FROM openjdk:8-jre-alpine
COPY ./target/service-registry-0.0.1-SNAPSHOT.jar /usr/src/bookqueryservie/
WORKDIR /usr/src/bookqueryservie/
EXPOSE 8761
CMD ["java", "-jar", "service-registry-0.0.1-SNAPSHOT.jar"]