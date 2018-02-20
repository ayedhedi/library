FROM openjdk:8-jre-alpine
COPY ./target/book-command-service-0.0.1-SNAPSHOT.jar /usr/src/bookcommandservie/
WORKDIR /usr/src/bookcommandservie/
EXPOSE 8181
CMD ["java", "-jar", "book-command-service-0.0.1-SNAPSHOT.jar"]