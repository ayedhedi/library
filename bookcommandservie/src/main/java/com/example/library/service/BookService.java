package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.event.BookSaveEvent;
import com.example.library.event.EventDispatcher;
import com.example.library.repository.BookReactiveRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Hedi Ayed on 03/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Slf4j
@Service
public class BookService {

    private final BookReactiveRepository bookRepository;
    private final EventDispatcher eventDispatcher;

    public BookService(BookReactiveRepository bookRepository, EventDispatcher eventDispatcher) {
        this.bookRepository = bookRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Transactional
    public Book saveBook(Book book) {
        Book saved =  bookRepository.save(book);
        eventDispatcher.send(new BookSaveEvent(saved.get_id()));
        return saved;
    }
}
