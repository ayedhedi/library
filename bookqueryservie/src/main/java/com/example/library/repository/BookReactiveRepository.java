package com.example.library.repository;

import com.example.library.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Hedi Ayed on 03/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
public interface BookReactiveRepository extends MongoRepository<Book, String> {

    @Query("{ _id: { $exists: true }}")
    List<Book> findAllBooks();
}
