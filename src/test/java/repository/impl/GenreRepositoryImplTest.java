package repository.impl;

import entity.Genre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.GenreRepository;


import static org.junit.jupiter.api.Assertions.*;

class GenreRepositoryImplTest {

    GenreRepository genreRepository = GenreRepositoryImpl.getInstance();

    Genre genre = new Genre("Test");

    @BeforeAll
    static void beforeAll() {
        Genre genre = new Genre("Test");
        GenreRepository genreRepo = GenreRepositoryImpl.getInstance();
        Genre genreByName = genreRepo.getGenreByName(genre.getName());
        if (genreByName != null) {
            genreRepo.deleteGenre(genreByName.getId());
        }
    }

    @Test
    void addGenre() {
        Genre addedGenre = genreRepository.addGenre(genre);
        Genre genreByIdExpected = genreRepository.findById(addedGenre.getId());
        assertEquals(genreByIdExpected, addedGenre);
    }

    @Test
    void getGenreByName() {
        Genre genre = new Genre("Test by Name");
        genre = genreRepository.addGenre(genre);
        Genre genreByName = genreRepository.getGenreByName(genre.getName());
        assertEquals(genre, genreByName);
        genreRepository.deleteGenre(genreByName.getId());
    }

    @Test
    void findById() {
        Genre genreByName = genreRepository.getGenreByName(genre.getName());
        Genre genreById = genreRepository.findById(genreByName.getId());
        assertEquals(genreByName, genreById);
    }

    @Test
    void updateGenre() {


    }

    @Test
    void deleteGenre() {
    }


    @Test
    void getAll() {
    }


    @Test
    void getBookIdByGenreId() {
    }
}