package repository.impl;

import entity.User;
import helper.DBConnection;
import repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private UserRepositoryImpl() {

    }

    private static UserRepository userRepository;

    public static UserRepository getInstance() {
        if (userRepository == null)
            userRepository = new UserRepositoryImpl();
        return userRepository;
    }

    public User addUser(User user) {
        String INSERT_USER = "insert into users(firstname, lastName, username, phone_number, password, role)" +
                " VALUES\n" +
                "    (?, ?, ?, ?, ?, ? ) ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, user.getFirstname());
            prepareStatement.setString(2, user.getLastName());
            prepareStatement.setString(3, user.getUsername());
            prepareStatement.setString(4, user.getPhoneNumber());
            prepareStatement.setString(5, user.getPassword());
            prepareStatement.setString(6, user.getRole());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                user.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

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
                String phoneNumber = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                User user = new User(id,
                        firstname,
                        lastName,
                        username,
                        phoneNumber,
                        password,
                        role);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return userList;
    }

    public User getUserById(Integer userId) {
        String GET_USER_BY_ID = "select * from users where id = " + userId;
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_USER_BY_ID)
        ) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                String username = resultSet.getString("username");
                String phoneNumber = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                return new User(id,
                        firstname,
                        lastName,
                        username,
                        phoneNumber,
                        password,
                        role);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;
    }

    public User findUserByUsername(String username) {
        String GET_USER_BY_USERNAME = "select * from users where username = '" + username + "'";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_USER_BY_USERNAME)
        ) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                String _username = resultSet.getString("username");
                String phoneNumber = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                return new User(id,
                        firstname,
                        lastName,
                        _username,
                        phoneNumber,
                        password,
                        role);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;
    }

    public User updateUserById(Integer userId, User user) {
        String UPDATE_USER_BY_ID = "update users set firstname = ?, " +
                "lastName = ?, username = ?, phone_number = ?, password = ?, role = ? \n" +
                "where id = ? ; ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_USER_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setString(1, user.getFirstname());
            prepareStatement.setString(2, user.getLastName());
            prepareStatement.setString(3, user.getUsername());
            prepareStatement.setString(4, user.getPhoneNumber());
            prepareStatement.setString(5, user.getPassword());
            prepareStatement.setString(6, user.getRole());
            prepareStatement.setInt(7, userId);
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                user.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user.getId() == null ? null : user;
    }

    public boolean deleteUserById(Integer userId) {
        String DELETE_USER_BY_ID = "delete FROM users where id = ? ;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_USER_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setInt(1, userId);
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return false;
    }

    @Override
    public List<User> findAllUsersSearch(String search) {
        List<User> userList = new ArrayList<>();
        String GET_ALL_USERS_SEARCH = "select * " +
                " from users u " +
                " where upper(u.firstname || u.lastname || u.username || u.phone_number) " +
                "          like upper('%' || '" + search + "' || '%') ";

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_USERS_SEARCH)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                String username = resultSet.getString("username");
                String phoneNumber = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                User user = new User(id,
                        firstname,
                        lastName,
                        username,
                        phoneNumber,
                        password,
                        role);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return userList;
    }
}
