package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookToUserDto {
    private String username;
    private Integer bookId;
    private String date;
    private Integer numberOfBooks;
}
