package repository.impl;

import entity.Book;
import org.junit.jupiter.api.Test;
import repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplTest {

    private BookRepository bookRepository = BookRepositoryImpl.getInstance();
    Book bookForAdding = new Book("Harry Potter and the Philosopher's Stone",
            23.0, 1, 223, 5, 5, 1);

    @Test
    void findById() {
        Book expected = new Book(1, "Harry Potter and the Philosopher's Stone",
                23.0, 1, 223, 5, 5, 1);
        assertEquals(expected, bookRepository.findById(1));
    }

    @Test
    void addBook() {
        Book savedTestBook = bookRepository.addBook(bookForAdding);
        Book expectedBook = bookRepository.findById(savedTestBook.getId());
        assertEquals(expectedBook, savedTestBook);
    }

    @Test
    void findAllBooks() {
        for (Book book : bookRepository.findAllBooks()) {
            Book expected = bookRepository.findById(book.getId());
            assertEquals(expected, book);
        }
    }

    @Test
    void updateBookById() {
        Book expected = new Book("Harry Potter and the Philosopher's Stone",
                23.0, 1, 223, 5, 5, 1);
        Book savedBook = bookRepository.addBook(expected);
        Book editedExpectedBook = savedBook;
        editedExpectedBook.setName("Test");
        editedExpectedBook.setCost(20D);
        editedExpectedBook.setGenreId(3);
        editedExpectedBook.setPageCount(100);
        editedExpectedBook.setTotalNumberOfBooks(10);
        editedExpectedBook.setLeftNumberOfBooks(10);
        editedExpectedBook.setAuthorId(2);

        Book editedFromRepo = bookRepository.updateBookById(savedBook.getId(), editedExpectedBook);
        assertEquals(editedExpectedBook, editedFromRepo);


        Book editedBookNonExistId = bookRepository.updateBookById(1000, editedExpectedBook);
        assertEquals(null, editedBookNonExistId);
    }

    @Test
    void deleteBookById() {
        Book addedBook = bookRepository.addBook(bookForAdding);
        boolean deletedTrue = bookRepository.deleteBookById(addedBook.getId());
        boolean deletedFalse = bookRepository.deleteBookById(addedBook.getId());
        assertTrue(deletedTrue);
        assertFalse(deletedFalse);
    }

}