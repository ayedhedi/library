FROM openjdk:8-jre-alpine
COPY ./target/book-indexing-service-0.0.1-SNAPSHOT.jar /usr/src/bookindexingservie/
WORKDIR /usr/src/bookindexingservie/
EXPOSE 8282
CMD ["java", "-jar", "book-indexing-service-0.0.1-SNAPSHOT.jar"]