package repository;

import entity.User;

import java.util.List;

public interface UserRepository {

    //    CREATE
    public User addUser(User user);

    //    READ
    public List<User> getAllUsers();

    /**
     * @param userId id of user
     * @return User or null
     * returns null if user with given id is not found
     */
    public User getUserById(Integer userId);

    /**
     * Returns null if user cannot be found with given username
     *
     * @param username username
     * @return User or null
     */
    public User findUserByUsername(String username);


//    UPDATE
    /**
     * @param userId
     * @param user
     * @return null if user is not found with given is otherwise updated us
     */
    public User updateUserById(Integer userId, User user);

//    DELETE
    /**
     * @param userId
     * @return boolean
     * returns true if user is deleted otherwise false
     */
    public boolean deleteUserById(Integer userId);


    List<User> findAllUsersSearch(String search);
}
