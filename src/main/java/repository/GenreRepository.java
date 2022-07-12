package repository;

import entity.Genre;

import java.util.List;

public interface GenreRepository {
    public Genre addGenre(Genre genre);

    public Genre updateGenre(Genre genre);

    public boolean deleteGenre(Integer genreId);

    public Genre findById(Integer genreId);

    public List<Genre> getAll();

    public Genre getGenreByName(String genreName);

    public Integer getBookIdByGenreId(Integer genreId);

}
