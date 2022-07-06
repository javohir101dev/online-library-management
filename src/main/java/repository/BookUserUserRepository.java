package repository;

import entity.BookUser;
import helper.DBConnection;
import helper.DateHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookUserUserRepository {

    public static void main(String[] args) {
        BookUserUserRepository repository = new BookUserUserRepository();
//        for (BookUser allBookUser : repository.findAllBookUsers()) {
//            System.out.println(allBookUser);
//        }
        BookUser bookUser = new BookUser(null, null, 7,2,7,false);
        System.out.println(repository.addBookUser(bookUser));
    }

    //    CREATE
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

//        READ
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

//    /**
//     * @param bookUserId id of bookUser
//     * @return BookUser or null
//     * returns null if bookUser with given id is not found
//     */
//    public BookUser findById(Integer bookUserId) {
//        String GET_BOOK_USERS_BY_ID = "select * from bookUser where id = " + bookUserId;
//        try (Connection connection = new DBConnection().getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(GET_BOOK_USERS_BY_ID)
//        ) {
//            if (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                Double cost = resultSet.getDouble("cost");
//                String genre = resultSet.getString("genre");
//                Integer pageCount = resultSet.getInt("page_count");
//                Integer totalNumberOfBookUsers = resultSet.getInt("total_number_of_bookUsers");
//                Integer leftNumberOfBookUsers = resultSet.getInt("left_number_of_bookUsers");
//                Integer authorId = resultSet.getInt("author_id");
//                return new BookUser(id,
//                        name,
//                        cost,
//                        genre,
//                        pageCount,
//                        BookUsers,
//                        BookUsers,
//                        authorId);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
//        return null;
//    }
//
////    UPDATE
//    /**
//     *
//     * @param bookUserId id of bookUser
//     * @param bookUser
//     * @return null if bookUser is not found with given is otherwise updated us
//     */
//    public BookUser updateBookUserById(Integer bookUserId, BookUser bookUser) {
//        String UPDATE_BOOK_USERS_BY_ID = "update bookUser set name = ?, " +
//                "cost = ?, genre = ?, page_count = ?, total_number_of_bookUsers = ?, left_number_of_bookUsers = ?, author_id = ? \n" +
//                "where id = ? ; ";
//        try (Connection connection = new DBConnection().getConnection();
//             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_BOOK_USERS_BY_ID, Statement.RETURN_GENERATED_KEYS)
//        ) {
//            prepareStatement.setString(1, bookUser.getName());
//            prepareStatement.setDouble(2, bookUser.getCost());
//            prepareStatement.setString(3, bookUser.getGenre());
//            prepareStatement.setInt(4, bookUser.getPageCount());
//            prepareStatement.setInt(5, bookUser.getTotalNumberOfBookUsers());
//            prepareStatement.setInt(6, bookUser.getLeftNumberOfBookUsers());
//            prepareStatement.setInt(7, bookUser.getAuthorId());
//            prepareStatement.setInt(8, bookUserId);
//            prepareStatement.execute();
//            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
//            if (generatedKeys.next()){
//                Integer id = generatedKeys.getInt(1);
//                bookUser.setId(id);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
//        return bookUser.getId()== null ? null : bookUser ;
//    }
//
////    DELETE
//    /**
//     *
//     * @param bookUserId id of deleted bookUser
//     * @return boolean
//     * returns true if bookUser is deleted otherwise false
//     */
//    public boolean deleteBookUserById(Integer bookUserId) {
//        String DELETE_BOOK_USERS_BY_ID = "delete FROM bookUser where id = ? ;";
//        try (Connection connection = new DBConnection().getConnection();
//             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_BOOK_USERS_BY_ID, Statement.RETURN_GENERATED_KEYS)
//        ) {
//            prepareStatement.setInt(1, bookUserId);
//            prepareStatement.execute();
//            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
//            if (generatedKeys.next()){
//                return true;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
//        return false;
//    }

}
