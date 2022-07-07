package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private Integer id;
    private String name;
    private Double cost;
    private String genre;
    private Integer pageCount;
    private Integer totalNumberOfBooks;
    private Integer leftNumberOfBooks;
    private Integer authorId;

    public Book(String name, Double cost, String genre, Integer pageCount, Integer totalNumberOfBooks, Integer leftNumberOfBooks, Integer authorId) {
        this.name = name;
        this.cost = cost;
        this.genre = genre;
        this.pageCount = pageCount;
        this.totalNumberOfBooks = totalNumberOfBooks;
        this.leftNumberOfBooks = leftNumberOfBooks;
        this.authorId = authorId;
    }
}
