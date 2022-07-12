package java.repository.impl;

import entity.Author;
import entity.Book;
import entity.Genre;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.BookRepository;
import repository.impl.AuthorRepositoryImplTest;
import repository.impl.BookRepositoryImpl;
import repository.impl.GenreRepositoryImplTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplTest {
    static AuthorRepositoryImplTest authorRepositoryImplTest=new AuthorRepositoryImplTest();
    static GenreRepositoryImplTest genreRepositoryImplTest=new GenreRepositoryImplTest();

    private static final BookRepository bookRepository= BookRepositoryImpl.getInstance();
    static Book book=new Book("Learning Spring boot",25.6,null,1456,5,1,null);
   @BeforeAll
  static   void addBook() {
      AuthorRepositoryImplTest.addAuthor();
      GenreRepositoryImplTest.addGenre();
       Author author = authorRepositoryImplTest.findById();
       Genre genre = genreRepositoryImplTest.findById();
       book.setAuthorId(author.getId());
       book.setGenreId(genre.getId());
       Book addBook = bookRepository.addBook(book);
       assertNotEquals(addBook.getId(),null);
       book.setId(addBook.getId());
   }

    @Test
    void findAllBooks() {
        Optional<Book> first = bookRepository.findAllBooks().stream().filter(book1 -> book1.getId().equals(book.getId())).findFirst();
        assertTrue(first.isPresent());
    }

    @Test
    Book findById() {
        Book byId = bookRepository.findById(book.getId());
        assertNotNull(byId);
        assertEquals(book.getId(),byId.getId());
        return byId;
   }

    @Test
    void updateBookById() {
      book.setName("Test");
      bookRepository.updateBookById(book.getId(),book);
        Book byId = bookRepository.findById(book.getId());
        assertEquals(book.getName(),byId.getName());
    }

    @AfterAll
   static void deleteBookById() {
       bookRepository.deleteBookById(book.getId());
        AuthorRepositoryImplTest.deleteAuthorById();
        GenreRepositoryImplTest.deleteGenre();
    }

    @Test
    void usersBooksByUserId() {
    }
}