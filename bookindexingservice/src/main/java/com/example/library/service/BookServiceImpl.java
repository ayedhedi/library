package com.example.library.service;

import com.example.library.client.BookQueryService;
import com.example.library.client.dto.Book;

import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Hedi Ayed on 05/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookQueryService bookQueryService;

    public BookServiceImpl(BookQueryService bookQueryService) {
        this.bookQueryService = bookQueryService;
    }

    @Override
    public void indexBook(String bookId) {

        Optional<Book> opBook = bookQueryService.findById(bookId);
        if (opBook.isPresent()) {
            log.info("Indexing new book: {} ", opBook.get());
        }else {
            log.warn("Cannot index book: cannot found book {}", bookId);
        }
    }
}
