package com.example.library.event;

import com.example.library.service.BookService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Hedi Ayed on 04/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Slf4j
@Component
public class EventsHandler {

    private final BookService bookService;

    public EventsHandler(BookService bookService) {
        this.bookService = bookService;
    }

    @RabbitListener(queues = "${application.configurations.queueName}")
    public void handelSaveBook(BookSaveEvent bookSaveEvent) {
        log.info("Got save event: {}", bookSaveEvent.getBookId());
        bookService.indexBook(bookSaveEvent.getBookId());
    }
}
