package com.example.library.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Hedi Ayed on 03/02/2018.
 *
 *
 * --------------------
 *
 * @author Hedi Ayed
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String _id;
    private String title;
    private int year;
    private String author;
}
