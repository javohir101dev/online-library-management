package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUserDto {
    private String username;
    private Integer bookId;
    private Integer numberOfBooks;
}
