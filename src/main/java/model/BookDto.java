package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Integer id;
    private String name;
    private Double cost;
    private String genre;
    private Integer pageCount;
    private Integer totalNumberOfBooks;
    private Integer leftNumberOfBooks;
    private Integer authorId;
}
