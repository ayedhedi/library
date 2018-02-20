package com.example.library.configuration;


import com.example.library.domain.Book;
import com.example.library.repository.BookReactiveRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public final class StaticDataLoader implements CommandLineRunner {

    private static final String fileName = "src/main/resources/books.csv";


    private final BookReactiveRepository bookReactiveRepository;

    public StaticDataLoader(BookReactiveRepository bookReactiveRepository) {
        this.bookReactiveRepository = bookReactiveRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        if (bookReactiveRepository.count() == 0) {
            log.info("No data found in DB, start reading JSON File: {}", fileName);
            //read file into stream, try-with-resources
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                stream.forEach((String line) -> {
                    String[] split = line.split(",");
                    Book b = new Book();
                    b.setTitle(split[1]);
                    b.setAuthor(split[2]);
                    try{
                        b.setYear(Integer.parseInt(split[3]));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    bookReactiveRepository.save(b);
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}