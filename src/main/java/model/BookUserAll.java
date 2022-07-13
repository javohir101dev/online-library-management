package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookUserAll {

    private Integer id;
    private String bookName;
    private String username;
    private Integer takenNumbers;

}
