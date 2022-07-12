package java.repository.impl;

import entity.Author;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import repository.AuthorRepository;
import repository.impl.AuthorRepositoryImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryImplTest {
    private static final AuthorRepository authorRepository= AuthorRepositoryImpl.getInstance();
 static Author author=new Author("Abdulla","Oripov",Date.valueOf(LocalDate.of(1941,03,21)));

@BeforeAll
   static void addAuthor() {
        Author create = authorRepository.addAuthor(author);
        author.setId(create.getId());
        assertNotEquals(create.getId(),null);

    }

    @Test

    void getAllAuthors() {
        List<Author> allAuthors = authorRepository.getAllAuthors();
        boolean contains = allAuthors.contains(author);
        assertTrue(contains);
    }

    @Test
    Author findById() {
        Author byId = authorRepository.findById(author.getId());
        assertEquals(byId.getId(),author.getId());
        return byId;
    }

    @Test()

    void updateAuthorById() {
        Author authorUpdate=new Author("Abdulla","Oripov test",new Date(LocalDate.of(1941,3,21).toEpochDay()));
       authorRepository.updateAuthorById(author.getId(), authorUpdate);
        Author byId = findById();
        assertEquals(byId.getLastName(), authorUpdate.getLastName());
    }

    @AfterAll
    static void deleteAuthorById() {
        boolean result = authorRepository.deleteAuthorById(author.getId());
        assertTrue(result);
    }

    @Test
    void authorBookWithAuthorId() {
    }
}