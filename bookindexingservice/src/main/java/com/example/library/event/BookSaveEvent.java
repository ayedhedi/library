package com.example.library.event;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Hedi Ayed on 03/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Getter
@Setter
@NoArgsConstructor
public class BookSaveEvent {
    private String bookId;
    private long timestamp;

    public BookSaveEvent(String bookId) {
        this.bookId = bookId;
        timestamp = (new Date()).getTime();
    }
}
