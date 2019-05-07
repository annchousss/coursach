package ru.itis.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {

    private Long id;

    private String title;
    private String description;

    private List<Feedback> feeds;
}
