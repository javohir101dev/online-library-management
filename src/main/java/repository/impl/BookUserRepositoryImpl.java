package repository.impl;

import entity.BookUser;
import helper.DBConnection;
import helper.DateHelper;
import model.BookUserAll;
import repository.BookUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookUserRepositoryImpl implements BookUserRepository {

    private static BookUserRepository bookUserRepository;

    private BookUserRepositoryImpl() {
    }

    public static BookUserRepository getInstance() {
        if (bookUserRepository == null)
            bookUserRepository = new BookUserRepositoryImpl();
        return bookUserRepository;
    }


    public BookUser addBookUser(BookUser bookUser) {
        String INSERT_BOOK_USERS = "insert into book_user(takenDate, returnedDate, bookId, takenNumberOfBooks, userId, isReturned)" +
                " VALUES\n" +
                "    (?, ?, ?, ?, ?, ?) ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(INSERT_BOOK_USERS, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setDate(1, DateHelper.toSqlDate(bookUser.getTakenDate()));
            prepareStatement.setDate(2, DateHelper.toSqlDate(bookUser.getReturnedDate()));
            prepareStatement.setInt(3, bookUser.getBookId());
            prepareStatement.setInt(4, bookUser.getTakenNumberOfBooks());
            prepareStatement.setInt(5, bookUser.getUserId());
            prepareStatement.setBoolean(6, bookUser.isReturned());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                bookUser.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return bookUser;
    }


    public List<BookUser> findAllBookUsers() {
        List<BookUser> bookUserList = new ArrayList<>();
        String GET_ALL_BOOK_USERS = "select * from book_user";

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_BOOK_USERS)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date takenDate = resultSet.getDate("takenDate");
                Date returnedDate = resultSet.getDate("returnedDate");
                Integer bookId = resultSet.getInt("bookId");
                Integer takenNumberOfBooks = resultSet.getInt("takenNumberOfBooks");
                Integer userId = resultSet.getInt("userId");
                Boolean isReturned = resultSet.getBoolean("isReturned");
                BookUser bookUser = new BookUser(id,
                        takenDate,
                        returnedDate,
                        bookId,
                        takenNumberOfBooks,
                        userId,
                        isReturned);
                bookUserList.add(bookUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bookUserList;
    }

    public int countUsersBookByUseridAndBookId(Integer userId, Integer bookId) {
        int count = 0;
        String COUNT_BOOKS_QUERY_BY_USERID_AND_BOOKID = "select sum(bu.takenNumberOfBooks) from book b inner join book_user\n" +
                " bu on b.id = bu.bookId\n" +
                " inner join users u on bu.userId = u.id\n" +
                " where u.id = " + userId + " and b.id = " + bookId + " ";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(COUNT_BOOKS_QUERY_BY_USERID_AND_BOOKID);
        ) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return count;
    }

    public int countUsersBookByUserid(Integer userId) {
        int count = 0;
        String COUNT_BOOKS_QUERY_BY_USERID_AND_BOOKID = "select count(*) from book_user bu " +
                " where bu.userid  = " + userId ;
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(COUNT_BOOKS_QUERY_BY_USERID_AND_BOOKID);
        ) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return count;
    }


    public String usersBookByBookId(Integer bookId) {
        String username = null;
        String USERS_BOOK_BY_BOOK_ID = "select u.username from book b inner join book_user\n" +
                " bu on b.id = bu.bookId\n" +
                " inner join users u on bu.userId = u.id\n" +
                " where b.id = " + bookId + " limit 1 ";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(USERS_BOOK_BY_BOOK_ID);
        ) {
            if (resultSet.next()) {
                username = resultSet.getString("username");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return username;
    }


    public BookUser findByUserIdAndBookId(Integer userId, Integer bookId) {
        String GET_BOOK_USERS_BY_ID = "select * from book_user bu where bu.userid = "
                + userId + " and bu.bookid = " + bookId + " limit 1 ";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_BOOK_USERS_BY_ID)
        ) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date takenDate = resultSet.getDate("takenDate");
                Date returnedDate = resultSet.getDate("returnedDate");
                Integer _bookId = resultSet.getInt("bookId");
                Integer takenNumberOfBooks = resultSet.getInt("takenNumberOfBooks");
                Integer _userId = resultSet.getInt("userId");
                Boolean isReturned = resultSet.getBoolean("isReturned");
                return new BookUser(id,
                        takenDate,
                        returnedDate,
                        _bookId,
                        takenNumberOfBooks,
                        _userId,
                        isReturned);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;
    }

    public BookUser updateBookUser(BookUser bookUser) {
        String UPDATE_BOOK_USERS_BY_ID = "update book_user set takenDate = ?, returnedDate = ?," +
                " takenNumberOfBooks = ?, isReturned = ? where userid = ? and bookid = ?;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_BOOK_USERS_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setDate(1, DateHelper.toSqlDate(bookUser.getTakenDate()));
            prepareStatement.setDate(2, DateHelper.toSqlDate(bookUser.getReturnedDate()));
            prepareStatement.setInt(3, bookUser.getTakenNumberOfBooks());
            prepareStatement.setBoolean(4, bookUser.isReturned());
            prepareStatement.setInt(5, bookUser.getUserId());
            prepareStatement.setInt(6, bookUser.getBookId());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                bookUser.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return bookUser.getId() == null ? null : bookUser;
    }

    public boolean deleteBookUserById(Integer bookUserId) {
        String DELETE_BOOK_USERS_BY_ID = "delete from book_user where id = ? ;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_BOOK_USERS_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setInt(1, bookUserId);
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

    public List<BookUserAll> getAllGivenBooks() {
        String GET_ALL_TAKEN_NUMBERS = "select b.id, b.name, u.username, bu.takennumberofbooks " +
                " from book_user bu " +
                "         inner join book b on b.id = bu.bookid " +
                "         inner join users u on bu.userid = u.id ";
        List<BookUserAll> bookUserAllList = new ArrayList<>();

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_TAKEN_NUMBERS)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                int takennumberofbooks = resultSet.getInt("takennumberofbooks");
                BookUserAll bookUserAll = new BookUserAll(id, name, username, takennumberofbooks);
                bookUserAllList.add(bookUserAll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bookUserAllList;
    }

}
