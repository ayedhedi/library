# About
The idea behind this project is to implement some concepts related to the micro-services architecture. The main patterns we are going to use in this project are:
- Event Driven Programming:
Programming where the primary activity is reaction to receipt of semantically significant signals (aka 'events'). See more details [here](http://wiki.c2.com/?EventDrivenProgramming).
- Microservice Architecture:
Microservices is an architectural style that structures an application as a collection of loosely coupled services, which implement business capabilities. See more details [here](http://microservices.io/)
- [CQRS](https://martinfowler.com/bliki/CQRS.html) (Command Query Responsibility Segregation)
- [API Gateway Pattern](http://microservices.io/patterns/apigateway.html)
- [Service Registry Pattern](http://microservices.io/patterns/service-registry.html)
- Load Balancing

# Basic Application
The application is a basic library (for books) in which the user is able to
create(does not make sens in real life) and search for books.
A book is defined by a title, a year of publication and an author's name.
The objective of the project is an introduction to the micro-services
architecture. The chosen technologies are Spring Boot, Spring Data, RabbitMQ,
Netflix OSS(Eureka, Zuul and Ribbon), MongoDB, Elastic Search and Angular for
the front-end.

# Architecture
As explained before, the architecture of this project is oriented micro-services
in which each component is implemented in a separated project (service). This
chose was made in order to show the concepts previously introduced:
- CQRS: I have separated the command (write/delete/update) component from
the query(read) one. The same object (book) is used in both of the services,
so it does not make sens to separate but again the objective here is to learn the pattern.
- Event Driven Programming: when the user (using wbe interface or a client wbe service)
 creates a new book (using command service) an event (a message) is created
 (of type new book) and sent to the broker, the message will be intercepted
 by the indexing service in order to index the new book.



















