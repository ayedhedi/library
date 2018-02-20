package com.example.library.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Handles the communication with the Event Bus.
 */
@Component
public class EventDispatcher {

    private RabbitTemplate rabbitTemplate;

    // The exchange to use to send anything related to Multiplication
    private String saveBookExchange;

    // The routing key to use to send this particular event
    private String saveBookKey;

    @Autowired
    EventDispatcher(final RabbitTemplate rabbitTemplate,
                    @Value("${application.configurations.exchange}")
                    final String saveBookExchange,
                    @Value("${application.configurations.saveBookKey}")
                    final String saveBookKey) {

        this.rabbitTemplate = rabbitTemplate;
        this.saveBookExchange = saveBookExchange;
        this.saveBookKey = saveBookKey;
    }

    public void send(final BookSaveEvent bookSaveEvent) {
        rabbitTemplate.convertAndSend(saveBookExchange, saveBookKey, bookSaveEvent);
    }
}
