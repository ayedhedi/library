package com.example.library.service;

import com.example.library.domain.Book;

import java.util.List;

/**
 * Created by Hedi Ayed on 14/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
public interface BookService {
    //TODO: this will be removed by implementing a dedicated indexing service
    List<Book> findByKeyWord(String keyword);

    List<Book> getAllBooks();
}
