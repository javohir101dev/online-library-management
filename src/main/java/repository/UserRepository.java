package repository;

import entity.User;
import helper.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    //    CREATE
    public User addUser(User user) {
        String INSERT_USER = "insert into users(firstname, lastName, username, password, account, role)" +
                " VALUES\n" +
                "    (?, ?, ?, ?, ?, ? ) ; ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(INSERT_USER,  Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, user.getFirstname());
            prepareStatement.setString(2, user.getLastName());
            prepareStatement.setString(3, user.getUsername());
            prepareStatement.setString(4, user.getPassword());
            prepareStatement.setDouble(5, user.getAccount());
            prepareStatement.setString(6, user.getRole());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                Integer id = generatedKeys.getInt(1);
                user.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

    //    READ
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String GET_ALL_USERS = "select * from users";

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_USERS)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Double account = resultSet.getDouble("account");
                String role = resultSet.getString("role");
                User user = new User(id,
                        firstname,
                        lastName,
                        username,
                        password,
                        account,
                        role);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return userList;
    }

    /**
     * @param userId
     * @return User or null
     * returns null if user with given id is not found
     */
    public User getUserById(Integer userId) {
        String GET_USER_BY_ID = "select * from users where id = " + userId;
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_USER_BY_ID);
        ) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Double account = resultSet.getDouble("account");
                String role = resultSet.getString("role");
                return new User(id,
                        firstname,
                        lastName,
                        username,
                        password,
                        account,
                        role);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;
    }

//    UPDATE
    /**
     *
     * @param userId
     * @param user
     * @return null if user is not found with given is otherwise updated us
     */
    public User updateUserById(Integer userId, User user) {
    String UPDATE_USER_BY_ID = "update users set firstname = ?, " +
            "lastName = ?, username = ?, password = ?, account = ?, role = ? \n" +
            "where id = ? ; ";
    try (Connection connection = new DBConnection().getConnection();
         PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_USER_BY_ID, Statement.RETURN_GENERATED_KEYS);
    ) {
        prepareStatement.setString(1, user.getFirstname());
        prepareStatement.setString(2, user.getLastName());
        prepareStatement.setString(3, user.getUsername());
        prepareStatement.setString(4, user.getPassword());
        prepareStatement.setDouble(5, user.getAccount());
        prepareStatement.setString(6, user.getRole());
        prepareStatement.setInt(7, userId);
        prepareStatement.execute();
        ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
        if (generatedKeys.next()){
            Integer id = generatedKeys.getInt(1);
            user.setId(id);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
    }
    return user.getId()== null ? null : user ;
}

//    DELETE
    /**
     *
     * @param userId
     * @return boolean
     * returns true if user is deleted otherwise false
     */
    public boolean deleteUserById(Integer userId) {
    String DELETE_USER_BY_ID = "delete FROM users where id = ? ;";
    try (Connection connection = new DBConnection().getConnection();
         PreparedStatement prepareStatement = connection.prepareStatement(DELETE_USER_BY_ID, Statement.RETURN_GENERATED_KEYS);
    ) {
        prepareStatement.setInt(1, userId);
        prepareStatement.execute();
        ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
        if (generatedKeys.next()){
            return true;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
    }
    return false;
}

}
