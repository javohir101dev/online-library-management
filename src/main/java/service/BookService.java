package service;

import entity.Book;
import helper.Validation;
import helper.messages.AppMessage;
import mapper.BookMapper;
import model.BookDto;
import model.ResponseDto;
import model.ValidDto;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.BookUserRepository;
import repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

import static helper.Validation.checkIsNegative;
import static helper.messages.AppMessage.ERROR;

public class BookService {
    private BookRepository bookRepository = new BookRepository();
    private GenreRepository genreRepository = new GenreRepository();
    private AuthorRepository authorRepository = new AuthorRepository();

    private BookUserRepository bookUserRepository = new BookUserRepository();

    public ResponseDto<BookDto> addBook(BookDto bookDto) {
        List<ValidDto> errors = checkIsNegative(bookDto);
        if (errors.size() > 0) {
            return new ResponseDto<>(false, "Valid Error", null, errors);
        }
        if (authorRepository.finfById(bookDto.getAuthorId()) == null) {
            return new ResponseDto<>(false,
                    String.format("Author with id: %s is not found",
                            bookDto.getAuthorId())
                    , null);
        }

        if (genreRepository.findById(bookDto.getGenreId()) == null){
            return new ResponseDto<>(false,
                    String.format("Genre with id: %s is not found",
                            bookDto.getGenreId())
                    , null);
        }

        try {
            Book book = BookMapper.toBook(bookDto);
            book.setLeftNumberOfBooks(book.getTotalNumberOfBooks());
            Book savedBook = bookRepository.addBook(book);
            return new ResponseDto<>(true,
                    String.format("Book with id %s is added", savedBook.getId()),
                    BookMapper.toBookDto(savedBook));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, ERROR);
        }
    }

    public ResponseDto<BookDto> update(BookDto bookDto) {
        try {

            if (bookRepository.findById(bookDto.getId()) == null) {
                return new ResponseDto<>(false, String.
                        format("Book with given id: %s is not found", bookDto.getId()));
            }
            if (authorRepository.finfById(bookDto.getAuthorId()) == null) {
                return new ResponseDto<>(false, String.
                        format("Author with given id: %s is not found", bookDto.getAuthorId()));
            }
            if (genreRepository.findById(bookDto.getAuthorId()) == null) {
                return new ResponseDto<>(false, String.
                        format("Genre with given id: %s is not found", bookDto.getAuthorId()));
            }
            List<ValidDto> errors = Validation.checkBook(bookDto);
            if (errors.size() > 0) {
                return new ResponseDto<>(false, errors.toString());
            }
            if (bookDto.getLeftNumberOfBooks() > bookDto.getTotalNumberOfBooks()) {
                return new ResponseDto<>(false,
                        "Left number of books cannot be greater than total number of books",
                        bookDto);
            }
            bookRepository.updateBookById(bookDto.getId(), BookMapper.toBook(bookDto));
            return new ResponseDto<>(true,
                    "Book is edited successfully", bookDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, AppMessage.DATA_BASE_ERROR);
        }
    }

    public ResponseDto<?> delete(Integer bookId) {
        Book bookById = bookRepository.findById(bookId);
        if (bookById == null) {
            return new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND);
        }
        String username = bookUserRepository.usersBookByBookId(bookId);
        if (username != null) {
            return new ResponseDto<>(false,
                    String
                            .format("Book with %s is must be taken first from user with username: %s",
                                    bookId, username));
        }

        bookRepository.deleteBookById(bookId);
        return new ResponseDto<>(true,
                String.format("Book %s is deleted successfully", bookById));
    }

    public ResponseDto<List<BookDto>> getAll() {
        List<Book> books = bookRepository.findAllBooks();
        List<BookDto> bookDtos = books.stream()
                .map(BookMapper::toBookDto)
                .collect(Collectors.toList());

        return new ResponseDto<>(true, AppMessage.OK, bookDtos);
    }

    public ResponseDto<BookDto> getById(Integer id) {
        Book book = bookRepository.findById(id);
        return book == null
                ?
                new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND)
                :
                new ResponseDto<>(true, AppMessage.OK, BookMapper.toBookDto(book));
    }
}
