package mapper.repository;

import entity.Book;
import helper.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {


    //    CREATE
    public Book addBook(Book book) {
        String INSERT_BOOK = "insert into book(name, cost, genre, page_count, total_number_of_books, left_number_of_books, author_id)" +
                " VALUES\n" +
                "    (?, ?, ?, ?, ?, ?, ?) ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, book.getName());
            prepareStatement.setDouble(2, book.getCost());
            prepareStatement.setString(3, book.getGenre());
            prepareStatement.setInt(4, book.getPageCount());
            prepareStatement.setInt(5, book.getTotalNumberOfBooks());
            prepareStatement.setInt(6, book.getLeftNumberOfBooks());
            prepareStatement.setInt(7, book.getAuthorId());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                book.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return book;
    }

    //    READ
    public List<Book> findAllBooks() {
        List<Book> bookList = new ArrayList<>();
        String GET_ALL_BOOKS = "select * from book order by id ";

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_BOOKS)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double cost = resultSet.getDouble("cost");
                String genre = resultSet.getString("genre");
                Integer pageCount = resultSet.getInt("page_count");
                Integer totalNumberOfBooks = resultSet.getInt("total_number_of_books");
                Integer leftNumberOfBooks = resultSet.getInt("left_number_of_books");
                Integer authorId = resultSet.getInt("author_id");
                Book book = new Book(id,
                        name,
                        cost,
                        genre,
                        pageCount,
                        totalNumberOfBooks,
                        leftNumberOfBooks,
                        authorId);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bookList;
    }

    /**
     * @param bookId id of book
     * @return Book or null
     * returns null if book with given id is not found
     */
    public Book findById(Integer bookId) {
        String GET_BOOK_BY_ID = "select * from book where id = " + bookId;
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_BOOK_BY_ID)
        ) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double cost = resultSet.getDouble("cost");
                String genre = resultSet.getString("genre");
                Integer pageCount = resultSet.getInt("page_count");
                Integer totalNumberOfBooks = resultSet.getInt("total_number_of_books");
                Integer leftNumberOfBooks = resultSet.getInt("left_number_of_books");
                Integer authorId = resultSet.getInt("author_id");
                return new Book(id,
                        name,
                        cost,
                        genre,
                        pageCount,
                        totalNumberOfBooks,
                        leftNumberOfBooks,
                        authorId);
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
     * @param bookId id of book
     * @param book
     * @return null if book is not found with given is otherwise updated us
     */
    public Book updateBookById(Integer bookId, Book book) {
        String UPDATE_BOOK_BY_ID = "update book set name = ?, " +
                "cost = ?, genre = ?, page_count = ?, total_number_of_books = ?, left_number_of_books = ?, author_id = ? \n" +
                "where id = ? ; ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_BOOK_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setString(1, book.getName());
            prepareStatement.setDouble(2, book.getCost());
            prepareStatement.setString(3, book.getGenre());
            prepareStatement.setInt(4, book.getPageCount());
            prepareStatement.setInt(5, book.getTotalNumberOfBooks());
            prepareStatement.setInt(6, book.getLeftNumberOfBooks());
            prepareStatement.setInt(7, book.getAuthorId());
            prepareStatement.setInt(8, bookId);
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                Integer id = generatedKeys.getInt(1);
                book.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return book.getId()== null ? null : book ;
    }

//    DELETE
    /**
     *
     * @param bookId id of deleted book
     * @return boolean
     * returns true if book is deleted otherwise false
     */
    public boolean deleteBookById(Integer bookId) {
        String DELETE_BOOK_BY_ID = "delete FROM book where id = ? ;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_BOOK_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setInt(1, bookId);
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
