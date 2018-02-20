package com.example.library.client;

import com.example.library.client.dto.Book;

import java.util.Optional;

/**
 * Created by Hedi Ayed on 05/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
public interface BookQueryService {
    Optional<Book> findById(String id);
}
