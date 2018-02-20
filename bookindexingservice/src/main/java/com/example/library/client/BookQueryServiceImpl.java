package com.example.library.client;

import com.example.library.client.dto.Book;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
public class BookQueryServiceImpl implements BookQueryService {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public BookQueryServiceImpl(final RestTemplate restTemplate,
                                final @Value("${application.configurations.apiGatewayHost}") String baseUrl) {

        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl + "/library/query/books";
    }

    @Override
    public Optional<Book> findById(final String id) {
        log.info("Looking for book with id: {}", id);
        StringBuilder url = new StringBuilder(baseUrl).append("/").append(id);

        try{
            Book book = restTemplate.getForObject(url.toString(), Book.class);
            return Optional.of(book);
        }catch (Exception ex) {
            log.warn("Cannot get book from {}, got : {}",url.toString(), ex.getMessage());
        }

        return Optional.empty();
    }
}
