package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.repository.BookReactiveRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
public class BookServiceImpl implements BookService{

    private final BookReactiveRepository bookRepository;

    public BookServiceImpl(BookReactiveRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById(String id) {
        return bookRepository.findOne(id);
    }

    //TODO: this will be removed by implementing a dedicated indexing service
    @Override
    public List<Book> findByKeyWord(String keyword){
        if (keyword == null) {
            keyword = "";
        }

        log.warn("Looking for books contain: {}",keyword);
        List<Book> allBooks = bookRepository.findAllBooks();
        String[] keywords = keyword.split(" ");

        return allBooks.stream()
                .filter(book -> keywords.length == 0 ||
                        Arrays.stream(keywords)
                              .anyMatch(s -> book.getTitle().toLowerCase().contains(s.toLowerCase()) ||
                                        book.getAuthor().toLowerCase().contains(s.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

}
