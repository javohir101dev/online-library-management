package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookShow {
    private Integer id;
    private String name;
    private Double cost;
    private String genre;
    private Integer pageCount;
    private Integer totalNumberOfBooks;
    private Integer leftNumberOfBooks;
    private String author;

}
