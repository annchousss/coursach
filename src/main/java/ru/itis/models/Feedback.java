package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {
   private Long id;

    private String firstName;

    private String content;

    private Customer customer;

    private Section section;

}
