package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {
    private String id;
    private String firstname;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String password;
}
