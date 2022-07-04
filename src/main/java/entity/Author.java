package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private Integer id;
    private String firstname;
    private String lastName;
    private Date birthDate;

    public Author(String firstname, String lastName, Date birthDate) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
