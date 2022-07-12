package service;

import entity.Book;
import entity.BookUser;
import entity.User;
import model.BookUserDto;
import model.ResponseDto;
import repository.*;
import repository.impl.BookRepositoryImpl;
import repository.impl.BookUserRepositoryImpl;
import repository.impl.UserRepositoryImpl;

import java.util.Date;

public class BookUserService {

    BookUserRepository bookUserRepository = BookUserRepositoryImpl.getInstance();
    BookRepository bookRepository = BookRepositoryImpl.getInstance();
    UserRepository userRepository = UserRepositoryImpl.getInstance();

    public ResponseDto addBookToUser(BookUserDto bookUserDto) {
        User userByUsername = userRepository.findUserByUsername(bookUserDto.getUsername());
        if (userByUsername == null) {
            return new ResponseDto(false,
                    String.format("User with username: %s is not found", bookUserDto.getUsername()), null);
        }
        Book bookById = bookRepository.findById(bookUserDto.getBookId());
        if (bookById == null) {
            return new ResponseDto(false,
                    String.format("Book with id: %s is not found", bookUserDto.getBookId()), null);
        }
        Integer numberOfBooks = bookUserDto.getNumberOfBooks();
        if (numberOfBooks < 1) {
            return new ResponseDto(false,
                    "Total number of books cannot be lower than 1", null);
        }
        Integer leftNumberOfBooks = bookById.getLeftNumberOfBooks();
        if (leftNumberOfBooks - numberOfBooks < 0) {
            return new ResponseDto(false,
                    String.format("Left number of books with id: %s is %s. " +
                                    "You cannot take %s books. Books is not enough",
                            bookById.getId(), leftNumberOfBooks,
                            bookUserDto.getNumberOfBooks()),
                    null);
        }


        BookUser bookUser = new BookUser(new java.util.Date(),
                null,
                bookById.getId(),
                numberOfBooks,
                userByUsername.getId(),
                false);
        BookUser savedBookUser = bookUserRepository.addBookUser(bookUser);
        bookById.setLeftNumberOfBooks(leftNumberOfBooks - numberOfBooks);
        bookRepository.updateBookById(savedBookUser.getBookId(), bookById);
        return new ResponseDto(true,
                String.format("%s books added to user: %s from book id: %s",
                        savedBookUser.getTakenNumberOfBooks(),
                        userByUsername.getUsername(),
                        savedBookUser.getBookId()),
                savedBookUser);
    }

    public ResponseDto takeBookFromUser(BookUserDto dto) {

        User userByUsername = userRepository.findUserByUsername(dto.getUsername());
        if (userByUsername == null) {
            return new ResponseDto(false,
                    String.format("User with username: %s is not found", dto.getUsername()), null);
        }
        Book bookById = bookRepository.findById(dto.getBookId());
        if (bookById == null) {
            return new ResponseDto(false,
                    String.format("Book with id: %s is not found", dto.getBookId()), null);
        }
        Integer numberOfBooks = dto.getNumberOfBooks();
        if (numberOfBooks < 1) {
            return new ResponseDto(false,
                    "Total number of books cannot be lower than 1", null);
        }
        Integer userId = userByUsername.getId();
        Integer bookId = dto.getBookId();
        Integer usersAllBooksCount = bookUserRepository
                .countUsersBookByUseridAndBookId(userId, bookId);
        if (usersAllBooksCount == 0) {
            return new ResponseDto(false,
                    "This user returned all books or did not taken any book",
                    null);
        }

        if ((usersAllBooksCount - numberOfBooks) < 0) {
            return new ResponseDto(false,
                    String.format("Given number of books  is %s " +
                                    "You cannot take %s books",
                            usersAllBooksCount,
                            numberOfBooks),
                    null);
        }

        BookUser byUserIdAndBookId = bookUserRepository.findByUserIdAndBookId(userId, bookId);
        int leftNumberOfBooks = usersAllBooksCount - numberOfBooks;
        if (leftNumberOfBooks == 0) {
            bookById.setLeftNumberOfBooks(bookById.getTotalNumberOfBooks());
            bookRepository.updateBookById(bookId, bookById);
            bookUserRepository.deleteBookUserById(byUserIdAndBookId.getId());
        } else {
            bookById.setLeftNumberOfBooks(bookById.getTotalNumberOfBooks() - numberOfBooks);
            bookRepository.updateBookById(bookId, bookById);
            byUserIdAndBookId.setTakenNumberOfBooks(leftNumberOfBooks);
            byUserIdAndBookId.setReturnedDate(new Date());
            bookUserRepository.updateBookUser(byUserIdAndBookId);
        }
        return new ResponseDto(true, String.format("%s Books returned successfully from user with username %s",
                numberOfBooks, userByUsername.getUsername()));
    }
}