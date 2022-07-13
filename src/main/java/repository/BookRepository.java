package repository;

import entity.Book;
import model.BookShow;
import model.UsersBook;
import repository.impl.BookRepositoryImpl;

import java.util.List;

public interface BookRepository {

    //    CREATE
    Book addBook(Book book);

    //    READ
    List<Book> findAllBooks();

    /**
     * @param bookId id of book
     * @return Book or null
     * returns null if book with given id is not found
     */
    public Book findById(Integer bookId);

//    UPDATE

    /**
     * @param bookId id of book
     * @param book
     * @return null if book is not found with given is otherwise updated us
     */
    Book updateBookById(Integer bookId, Book book);

//    DELETE

    /**
     * @param bookId id of deleted book
     * @return boolean
     * returns true if book is deleted otherwise false
     */

    boolean deleteBookById(Integer bookId);

    /**
     * returns users books list
     *
     * @param userId id of user
     * @return List<UsersBook>
     */
    List<UsersBook> usersBooksByUserId(Integer userId);

    /**
     * Returns book with values (Genre, Author)
     * @return List<BookShow>
     */
    List<BookShow> findAllBooksShow();

    /**
     * Searches from books due to name by ignore case
     * @param search String
     * @return List of BookShows
     */
    public List<BookShow> findAllBooksShowSearch(String search);

}
