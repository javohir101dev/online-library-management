package java.repository.impl;

import entity.Genre;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import repository.GenreRepository;
import repository.impl.GenreRepositoryImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreRepositoryImplTest {
    private static final GenreRepository genreRepository= GenreRepositoryImpl.getInstance();
    static Genre genre=new Genre(null,"IT Technology");

    @BeforeAll
    static void addGenre() {
        Genre addGenre = genreRepository.addGenre(genre);
        genre.setId(addGenre.getId());
        assertNotNull(addGenre.getId());
    }

    @Test
    void updateGenre() {
        Genre genreUpdate=new Genre(genre.getId(), "Art");
        genreRepository.updateGenre(genreUpdate);
        Genre byId = findById();
        assertEquals(genreUpdate.getName(),byId.getName());
        genre=byId;

    }

    @AfterAll
   static void deleteGenre() {
        boolean deleteGenre = genreRepository.deleteGenre(genre.getId());
        assertTrue(deleteGenre);
    }

    @Test
    Genre findById() {
        Genre byId = genreRepository.findById(genre.getId());
        assertNotNull(byId);
        return byId;
    }

    @Test
    void getAll() {
        List<Genre> all = genreRepository.getAll();
        assertTrue(all.contains(genre));
    }

    @Test
    void getGenreByName() {
        Genre genreByName = genreRepository.getGenreByName(genre.getName());
        assertNotNull(genreByName.getName());
        assertEquals(genre.getName(),genreByName.getName());
    }

    @Test
    void getBookIdByGenreId() {
    }
}