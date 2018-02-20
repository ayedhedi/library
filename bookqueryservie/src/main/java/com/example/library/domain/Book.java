package com.example.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Hedi Ayed on 03/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String _id;
    private String title;
    private int year;
    private String author;
}
