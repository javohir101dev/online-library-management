package java.repository.impl;

import entity.Book;
import entity.BookUser;
import entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.BookRepository;
import repository.BookUserRepository;
import repository.impl.BookUserRepositoryImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookUserRepositoryImplTest {
private static final BookUserRepository bookUserRepository= BookUserRepositoryImpl.getInstance();
static BookRepositoryImplTest bookRepositoryImplTest=new BookRepositoryImplTest();
static UserRepositoryImplTest userRepositoryImplTest=new UserRepositoryImplTest();
static Integer bookId;
static Integer userId;
static BookUser bookUser=new BookUser(Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(7)),bookId,5,userId,false);
    @BeforeAll
   static void addBookUser() {
        BookRepositoryImplTest.addBook();
        Book byId = bookRepositoryImplTest.findById();
        assertNotNull(byId.getId());
        bookId=byId.getId();
        bookUser.setBookId(bookId);
        UserRepositoryImplTest.addUser();
        User userById = userRepositoryImplTest.getUserById();
        assertNotNull(userById);
        userId=userById.getId();
        bookUser.setUserId(userId);

        BookUser addBookUser = bookUserRepository.addBookUser(bookUser);
        assertNotNull(addBookUser);

    }

    @Test
    void findAllBookUsers() {
        Optional<BookUser> first = bookUserRepository.findAllBookUsers().stream().filter(bookUser1 -> bookUser1.getId().equals(bookUser.getId())).findFirst();
        assertTrue(first.isPresent());
    }

    @Test
    void countUsersBookByUseridAndBookId() {

            int count = bookUserRepository.countUsersBookByUseridAndBookId(userId, bookId);
       assertNotEquals(count,-1);

    }

    @Test
    void usersBookByBookId() {
        String userName = bookUserRepository.usersBookByBookId(bookId);
        assertNotNull(userName);
    }

    @Test
    void findByUserIdAndBookId() {
        BookUser byUserIdAndBookId = bookUserRepository.findByUserIdAndBookId(userId, bookId);
        assertNotNull(byUserIdAndBookId);
    }

    @Test
    void updateBookUser() {
        bookUser.setReturned(true);
        bookUserRepository.updateBookUser(bookUser);
        BookUser byUserIdAndBookId = bookUserRepository.findByUserIdAndBookId(userId, bookId);
        assertEquals(bookUser.isReturned(),byUserIdAndBookId.isReturned());
    }

    @AfterAll
  static   void deleteBookUserById() {
        boolean deleteBookUserById = bookUserRepository.deleteBookUserById(bookUser.getId());
        UserRepositoryImplTest.deleteUserById();
        BookRepositoryImplTest.deleteBookById();
        assertTrue(deleteBookUserById);
    }
}