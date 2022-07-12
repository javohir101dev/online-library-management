package repository;

import entity.Genre;
import helper.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreRepository {
    public Genre addGenre(Genre genre) {
        genre.setId(null);
        String QUERY = "INSERT INTO genre(name) VALUES(?)";

        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, genre.getName());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                genre.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return genre;
    }

    public Genre updateGenre(Genre genre) {
        String UPDATE_QUERY = "UPDATE genre set name = ? WHERE ID = ?";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setInt(2, genre.getId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            return resultSet.next() ? genre : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteGenre(Integer genreId) {
        String DELETE_QUERY = "DELETE from genre where id = ?";
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, genreId);
            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Genre findById(Integer genreId) {
        String GET_BY_ID_QUERY = "SELECT * FROM genre WHERE id= " + genreId;
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_BY_ID_QUERY);
        ) {
            if (resultSet.next()) {
                Integer ids = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return Genre.builder().id(ids).name(name).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        String GET_ALL_QUERY = "SELECT * FROM genre ORDER BY id";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);

        ) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                genres.add(new Genre(id, name));
            }
            return genres;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Genre getGenreByName(String genreName) {
        String GET_GENRE_BY_NAME_QUERY = "SELECT * FROM genre WHERE name = '" + genreName + "' ";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_GENRE_BY_NAME_QUERY);
        ) {
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Genre(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Integer getBookIdByGenreId(Integer genreId) {
        String GET_GENRE_BY_NAME_QUERY = " select b.id from genre g " +
                " inner join book b on g.id = b.genre_id " +
                " where g.id = " + genreId + " order by b.id limit 1 ";
        try (Connection connection = new DBConnection().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_GENRE_BY_NAME_QUERY);
        ) {
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
