package repository.impl;

import entity.Book;
import helper.DBConnection;
import model.BookShow;
import model.UsersBook;
import repository.BookRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static BookRepository book;

    private BookRepositoryImpl() {
    }

    public static BookRepository getInstance() {
        if (book == null)
            book = new BookRepositoryImpl();
        return book;
    }


    public Book addBook(Book book) {
        String INSERT_BOOK = "insert into book(name, cost, genre_id, page_count, total_number_of_books, left_number_of_books, author_id)" +
                " VALUES\n" +
                "    (?, ?, ?, ?, ?, ?, ?) ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(INSERT_BOOK, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, book.getName());
            prepareStatement.setDouble(2, book.getCost());
            prepareStatement.setInt(3, book.getGenreId());
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
                Integer genreId = resultSet.getInt("genre_id");
                Integer pageCount = resultSet.getInt("page_count");
                Integer totalNumberOfBooks = resultSet.getInt("total_number_of_books");
                Integer leftNumberOfBooks = resultSet.getInt("left_number_of_books");
                Integer authorId = resultSet.getInt("author_id");
                Book book = new Book(id,
                        name,
                        cost,
                        genreId,
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

    public List<Book> findAllBooksWithAuthor() {
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
                Integer genreId = resultSet.getInt("genre_id");
                Integer pageCount = resultSet.getInt("page_count");
                Integer totalNumberOfBooks = resultSet.getInt("total_number_of_books");
                Integer leftNumberOfBooks = resultSet.getInt("left_number_of_books");
                Integer authorId = resultSet.getInt("author_id");
                Book book = new Book(id,
                        name,
                        cost,
                        genreId,
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
                Integer genreId = resultSet.getInt("genre_id");
                Integer pageCount = resultSet.getInt("page_count");
                Integer totalNumberOfBooks = resultSet.getInt("total_number_of_books");
                Integer leftNumberOfBooks = resultSet.getInt("left_number_of_books");
                Integer authorId = resultSet.getInt("author_id");
                return new Book(id,
                        name,
                        cost,
                        genreId,
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

    public Book updateBookById(Integer bookId, Book book) {
        String UPDATE_BOOK_BY_ID = "update book set name = ?, " +
                "cost = ?, genre_id = ?, page_count = ?, total_number_of_books = ?, left_number_of_books = ?, author_id = ?  " +
                "where id = ? ; ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_BOOK_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setString(1, book.getName());
            prepareStatement.setDouble(2, book.getCost());
            prepareStatement.setInt(3, book.getGenreId());
            prepareStatement.setInt(4, book.getPageCount());
            prepareStatement.setInt(5, book.getTotalNumberOfBooks());
            prepareStatement.setInt(6, book.getLeftNumberOfBooks());
            prepareStatement.setInt(7, book.getAuthorId());
            prepareStatement.setInt(8, bookId);
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                book.setId(id);
                return book;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteBookById(Integer bookId) {
        String DELETE_BOOK_BY_ID = "delete FROM book where id = ? ;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_BOOK_BY_ID, Statement.RETURN_GENERATED_KEYS)
        ) {
            prepareStatement.setInt(1, bookId);
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

    public List<UsersBook> usersBooksByUserId(Integer userId) {
        String GET_USERS_BOOKS_BY_USER_ID = " select b.id, b.name, b.cost, g.name " +
                " as genre, b.page_count, a.firstname || a.lastname as author, " +
                " bu.takennumberofbooks from book  b " +
                " inner join author a on a.id = b.author_id " +
                " inner join genre g on g.id = b.genre_id " +
                " inner join book_user bu on b.id = bu.bookid " +
                " where bu.userid = " + userId +
                " order by b.id ";
        List<UsersBook> bookList = new ArrayList<>();
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_USERS_BOOKS_BY_USER_ID)
        ) {

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String genre = resultSet.getString("genre");
                int pageCount = resultSet.getInt("page_count");
                double cost = resultSet.getDouble("cost");
                String author = resultSet.getString("author");
                int takenNumbers = resultSet.getInt("takennumberofbooks");

                UsersBook usersBook = new UsersBook(id,
                        name,
                        genre,
                        pageCount,
                        cost,
                        author,
                        takenNumbers);
                bookList.add(usersBook);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return bookList;
    }


    public List<BookShow> findAllBooksShow() {
        List<BookShow> bookList = new ArrayList<>();
        String GET_ALL_BOOKS_SHOW = "select b.id,\n" +
                "       b.name,\n" +
                "       b.cost,\n" +
                "       g.name                           as genre,\n" +
                "       b.page_count,\n" +
                "       b.total_number_of_books,\n" +
                "       b.left_number_of_books,\n" +
                "       a.firstname || ' ' || a.lastname as author\n" +
                "from book b\n" +
                "         inner join author a on b.author_id = a.id\n" +
                "         inner join genre g on g.id = b.genre_id\n" +
                "order by b.id  ";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_BOOKS_SHOW)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double cost = resultSet.getDouble("cost");
                String genre = resultSet.getString("genre");
                Integer pageCount = resultSet.getInt("page_count");
                Integer totalNumberOfBooks = resultSet.getInt("total_number_of_books");
                Integer leftNumberOfBooks = resultSet.getInt("left_number_of_books");
                String author = resultSet.getString("author");
                BookShow book = new BookShow(id,
                        name,
                        cost,
                        genre,
                        pageCount,
                        totalNumberOfBooks,
                        leftNumberOfBooks,
                        author);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bookList;
    }

    public List<BookShow> findAllBooksShowSearch(String search) {
        List<BookShow> bookList = new ArrayList<>();
        String GET_ALL_BOOKS_SHOW_SEARCH = "select b.id, " +
                "       b.name, " +
                "       b.cost, " +
                "       g.name                           as genre, " +
                "       b.page_count, " +
                "       b.total_number_of_books, " +
                "       b.left_number_of_books, " +
                "       a.firstname || ' ' || a.lastname as author " +
                " from book b " +
                "         inner join author a on b.author_id = a.id " +
                "         inner join genre g on g.id = b.genre_id " +
                " where upper(b.name || g.name || a.firstname || ' ' || a.lastname  || b.cost) like upper('%' || '" + search + "' || '%')" +
                "order by b.id  ";

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_BOOKS_SHOW_SEARCH)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double cost = resultSet.getDouble("cost");
                String genre = resultSet.getString("genre");
                Integer pageCount = resultSet.getInt("page_count");
                Integer totalNumberOfBooks = resultSet.getInt("total_number_of_books");
                Integer leftNumberOfBooks = resultSet.getInt("left_number_of_books");
                String author = resultSet.getString("author");
                BookShow book = new BookShow(id,
                        name,
                        cost,
                        genre,
                        pageCount,
                        totalNumberOfBooks,
                        leftNumberOfBooks,
                        author);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bookList;
    }
}
