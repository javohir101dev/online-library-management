package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBookModel {

    private Integer id;
    private String name;
    private Double cost;
    private String genre;
    private Integer pageCount;
    private Integer totalNumberOfBooks;
    private Integer leftNumberOfBooks;
    private Integer authorId;

}
