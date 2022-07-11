package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String firstname;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String password;
    private String role;

    public User(String firstname, String lastName, String username, String phoneNumber, String password, String role) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }
}
