package service;

import entity.Book;
import entity.BookUser;
import entity.User;
import helper.DateHelper;
import model.AddBookToUserDto;
import model.ResponseDto;
import repository.BookRepository;
import repository.BookUserUserRepository;
import repository.UserRepository;

import java.sql.Date;

public class BookUserService {

    BookUserUserRepository bookUserUserRepository = new BookUserUserRepository();
    BookRepository bookRepository = new BookRepository();
    UserRepository userRepository = new UserRepository();

    public ResponseDto addBookToUser(AddBookToUserDto addBookToUserDto) {
        User userByUsername = userRepository.findUserByUsername(addBookToUserDto.getUsername());
        if (userByUsername == null) {
            return new ResponseDto(false,
                    String.format("User with username: %s is not found", addBookToUserDto.getUsername()), null);
        }
        Book bookById = bookRepository.findById(addBookToUserDto.getBookId());
        if (bookById == null) {
            return new ResponseDto(false,
                    String.format("Book with id: %s is not found", addBookToUserDto.getBookId()), null);
        }
        Integer numberOfBooks = addBookToUserDto.getNumberOfBooks();
        if (numberOfBooks < 1) {
            return new ResponseDto(false,
                    "Total number of books cannot be lower than 1", null);
        }
        Date date = DateHelper.toSqlDateFromString(addBookToUserDto.getDate());
        if (date == null) {
            return new ResponseDto(false, "Please enter date in form yyyy-MM-dd or (2022-07-15)", null);
        }

        Integer leftNumberOfBooks = bookById.getLeftNumberOfBooks();
        if (leftNumberOfBooks - numberOfBooks < 0) {
            return new ResponseDto(false,
                    String.format("Left number of books with id: %s is %s. " +
                                    "You cannot take %s books. Books is not enough",
                            bookById.getId(), leftNumberOfBooks,
                            addBookToUserDto.getNumberOfBooks()),
                    null);
        }


        BookUser bookUser = new BookUser(new java.util.Date(),
                null,
                bookById.getId(),
                numberOfBooks,
                userByUsername.getId(),
                false);
        BookUser savedBookUser = bookUserUserRepository.addBookUser(bookUser);
        bookById.setLeftNumberOfBooks(leftNumberOfBooks - numberOfBooks);
        bookRepository.updateBookById(savedBookUser.getBookId(), bookById);
        return new ResponseDto(true,
                String.format("%s books added to user: %s from book id: %s",
                        savedBookUser.getTakenNumberOfBooks(),
                        userByUsername.getUsername(),
                        savedBookUser.getBookId()),
                savedBookUser);
    }

}
