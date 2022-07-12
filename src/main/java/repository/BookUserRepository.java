package repository;

import entity.BookUser;

import java.util.List;

public interface BookUserRepository {

    //    CREATE
    public BookUser addBookUser(BookUser bookUser);

    //        READ
    public List<BookUser> findAllBookUsers();

    public int countUsersBookByUseridAndBookId(Integer userId, Integer bookId);

    /**
     * Returns username if user have taken book with given id otherwise null
     * @param bookId id of book
     * @return username
     */
    public String usersBookByBookId(Integer bookId);

    /**
     * returns null if bookUser with given userId and bookId is not found
     * @param userId user's id
     * @param bookId books's id
     * @return BookUser
     */
    public BookUser findByUserIdAndBookId(Integer userId, Integer bookId);

//        UPDATE
    public BookUser updateBookUser(BookUser bookUser);

    //    DELETE
    public boolean deleteBookUserById(Integer bookUserId);
}
