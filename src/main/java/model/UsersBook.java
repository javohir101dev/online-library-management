package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersBook {
    private Integer id;
    private String name;
    private String genre;
    private Integer pageCount;
    private Double cost;
    private String author;
    private Integer takenNumbers;
}
