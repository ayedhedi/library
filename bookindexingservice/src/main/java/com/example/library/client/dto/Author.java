package com.example.library.client.dto;

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
public class Author {
    private String firstName;
    private String lastName;
}
