package repository;

import entity.BookUser;
import model.BookUserAll;

import java.util.List;

public interface BookUserRepository {

    //    CREATE
     BookUser addBookUser(BookUser bookUser);

    //        READ
     List<BookUser> findAllBookUsers();

     int countUsersBookByUseridAndBookId(Integer userId, Integer bookId);

    /**
     * Returns username if user have taken book with given id otherwise null
     * @param bookId id of book
     * @return username
     */
     String usersBookByBookId(Integer bookId);

    /**
     * returns null if bookUser with given userId and bookId is not found
     * @param userId user's id
     * @param bookId books's id
     * @return BookUser
     */
     BookUser findByUserIdAndBookId(Integer userId, Integer bookId);

//        UPDATE
     BookUser updateBookUser(BookUser bookUser);

    //    DELETE
     boolean deleteBookUserById(Integer bookUserId);

    /**
     * Returns all given books list with username and book id
     * @return BookUserAll or empty list
     */
     List<BookUserAll> getAllGivenBooks();

    /**
     * Counts book_user by userId
     * @param userId id of user
     * @return thr number of book user
     */
     int countUsersBookByUserid(Integer userId);

    List<BookUserAll> findAllBookUserAllSearch(String search);
}
