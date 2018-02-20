package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.service.BookServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Hedi Ayed on 03/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@RestController
@RequestMapping("/library/query/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book findOne(final @PathVariable(name = "id") String id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String keyword){
        return keyword == null ?
                bookService.getAllBooks() :
                bookService.findByKeyWord(keyword);
    }

}
