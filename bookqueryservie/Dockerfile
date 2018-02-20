FROM openjdk:8-jre-alpine
COPY ./target/book-query-servie-0.0.1-SNAPSHOT.jar /usr/src/bookqueryservie/
WORKDIR /usr/src/bookqueryservie/
EXPOSE 8080
CMD ["java", "-jar", "book-query-servie-0.0.1-SNAPSHOT.jar"]