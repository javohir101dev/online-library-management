package repository.impl;

import entity.Author;
import helper.DBConnection;
import model.AuthorDto;
import model.BookShow;
import model.ResponseDto;
import repository.AuthorRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {

    public AuthorRepositoryImpl() {
    }

    private static AuthorRepository authorRepository;

    public static AuthorRepository getInstance() {
        if (authorRepository == null)
            authorRepository = new AuthorRepositoryImpl();
        return authorRepository;
    }

    public Author addAuthor(Author author) {
        String INSERT_AUTHOR = "insert into author(firstname, lastName, birth_date)" +
                " VALUES\n" +
                "    (?, ?, ? ) ; ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, author.getFirstname());
            prepareStatement.setString(2, author.getLastName());
            prepareStatement.setDate(3, author.getBirthDate());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                author.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return author;
    }

    public List<Author> getAllAuthors() {
        List<Author> authorList = new ArrayList<>();
        String GET_ALL_AUTHORS = "select * from author";

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_AUTHORS)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                Date birthDate = resultSet.getDate("birth_date");
                Author author = new Author(id,
                        firstname,
                        lastName,
                        birthDate);
                authorList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return authorList;
    }

    public Author findById(Integer authorId) {
        String GET_AUTHOR_BY_ID = "select * from author where id = " + authorId;
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_AUTHOR_BY_ID);
        ) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                Date birthDate = resultSet.getDate("birth_date");
                return new Author(id,
                        firstname,
                        lastName,
                        birthDate);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;
    }

    public Author updateAuthorById(Integer authorId, Author author) {
        author.setId(null);
        String UPDATE_AUTHOR_BY_ID = "update author set firstname = ?, " +
                "lastName = ?, birth_date = ?  \n" +
                "where id = ? ; ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_AUTHOR_BY_ID, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, author.getFirstname());
            prepareStatement.setString(2, author.getLastName());
            prepareStatement.setDate(3, author.getBirthDate());
            prepareStatement.setInt(4, authorId);
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Integer id = generatedKeys.getInt(1);
                author.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return author.getId() == null ? null : author;
    }

    public boolean deleteAuthorById(Integer authorId) {
        String DELETE_AUTHOR_BY_ID = "delete FROM author where id = ? ;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_AUTHOR_BY_ID, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setInt(1, authorId);
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

    public Integer authorBookWithAuthorId(Integer authorId) {
        Integer bookId = null;
        String AUTHOR_BOOK_BY_BOOK_ID = " select b.id from book b " +
                " inner join author a on a.id = b.author_id " +
                " where a.id = " + authorId + " order by b.id limit 1 ;";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(AUTHOR_BOOK_BY_BOOK_ID);
        ) {
            if (resultSet.next()) {
                bookId = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return bookId;
    }


    @Override
    public List<Author> findAllAuthorsSearch(String search) {
        List<Author> authorList = new ArrayList<>();
        String GET_ALL_AUTHORS = "select * from author where " +
                " upper(author.firstname || author.lastname) like upper('%' || '" + search + "' || '%');";

        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_AUTHORS)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                Date birthDate = resultSet.getDate("birth_date");
                Author author = new Author(id,
                        firstname,
                        lastName,
                        birthDate);
                authorList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return authorList;

    }
}
