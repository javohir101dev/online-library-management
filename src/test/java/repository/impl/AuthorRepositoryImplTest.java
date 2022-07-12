package repository.impl;

import entity.Author;
import helper.DBConnection;
import helper.DBConnectionTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryImplTest {
    @BeforeEach
    void clean(){
        Author author=new Author("Abdulla","Oripov",new Date(LocalDate.of(1941,3,21).toEpochDay()));
        String DELETE_AUTHOR_BY_NAME = "delete FROM author where firstname = ? ;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_AUTHOR_BY_NAME, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, author.getFirstname());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    @Test
    int addAuthor() {
        Author author=new Author("Abdulla","Oripov",new Date(LocalDate.of(1941,3,21).toEpochDay()));

        String INSERT_AUTHOR = "insert into author(firstname, lastName, birth_date)" +
                " VALUES\n" +
                "    (?, ?, ? ) ; ";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(INSERT_AUTHOR,  Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setString(1, author.getFirstname());
            prepareStatement.setString(2, author.getLastName());
            prepareStatement.setDate(3, author.getBirthDate());
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                Integer id = generatedKeys.getInt(1);
                author.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

       assertNotEquals(author.getId(),null);
        return author.getId();
    }


    @Test
    Author findById(Integer byId) {
        Author author=null;
        int resultId = 0;
        String GET_AUTHOR_BY_ID = "select * from author where id = " + byId;
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_AUTHOR_BY_ID);
        ) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastName");
                Date birthDate = resultSet.getDate("birth_date");
                author = new Author(id,
                        firstname,
                        lastName,
                        birthDate);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        assert author != null;
        assertEquals(byId,author.getId());
        return author;
    }

    @Test
    void getAllAuthors() {
        int authorId = addAuthor();
        boolean hasAuthor=false;
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
        for (Author author : authorList) {
            if (author.getId().equals(authorId)){
                hasAuthor=true;
                break;
            }
        }
        assertTrue(hasAuthor);
    }

    @Test
    void updateAuthorById() {
        Author author=new Author("Abdulla test","Oripov",new Date(LocalDate.of(1941,3,21).toEpochDay()));
        Author authorUpdate=null;
        int authorId = addAuthor();
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
            if (generatedKeys.next()){
                Integer id = generatedKeys.getInt(1);
                authorUpdate = findById(id);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        assertNotEquals(authorUpdate,null);
        assert authorUpdate != null;
        assertEquals("Abdulla test",authorUpdate.getFirstname());

    }

    @Test
    void deleteAuthorById() {
        int authorId = addAuthor();
        Author byId=null;
        String DELETE_AUTHOR_BY_ID = "delete FROM author where id = ? ;";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_AUTHOR_BY_ID, Statement.RETURN_GENERATED_KEYS);
        ) {
            prepareStatement.setInt(1, authorId);
            prepareStatement.execute();
            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                try {
                    byId = findById(authorId);
                }catch (AssertionError ignored){
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        assertNull(byId);
    }

    @Test
    void authorBookWithAuthorId() {
    }

}