package repository.impl;

import entity.User;
import entity.enums.Roles;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

   private static final UserRepository userRepository= UserRepositoryImpl.getInstance();
   static User user=new User("Javokhirbek","Uralov","Jokha","+998997777777","@Jokha1234", Roles.ADMIN.name());

    @BeforeAll
   static void addUser() {
        User addUser = userRepository.addUser(user);
        assertNotNull(addUser.getId());
        user.setId(addUser.getId());
    }

    @Test
    void getAllUsers() {
        List<User> allUsers = userRepository.getAllUsers();
        assertTrue(allUsers.contains(user));
    }

    @Test
    User getUserById() {
        User userById = userRepository.getUserById(user.getId());
        assertEquals(user.getId(),userById.getId());
        return userById;
    }

    @Test
    void findUserByUsername() {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        assertEquals(user.getUsername(),userByUsername.getUsername());
    }

    @Test
    void updateUserById() {
        User userUpdate=new User("Javokhirbek","Uralov","Jokha","+998996666666","@Jokha1234", Roles.ADMIN.name());
        userRepository.updateUserById(user.getId(), userUpdate);
        User userById = getUserById();
        assertEquals(userById.getPhoneNumber(),userUpdate.getPhoneNumber());
    }

    @AfterAll
    static void deleteUserById() {
        boolean deleteUserById = userRepository.deleteUserById(user.getId());
        assertTrue(deleteUserById);
    }
}