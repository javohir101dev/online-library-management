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

import java.util.List;
import java.util.stream.Collectors;

import static helper.Validation.checkIsNegative;

public class BookService {
    private BookRepository bookRepository = new BookRepository();
    private AuthorRepository authorRepository = new AuthorRepository();

    public ResponseDto<BookDto> addBook(BookDto bookDto) {
        List<ValidDto> errors = checkIsNegative(bookDto);
        if (errors.size() > 0)
            return new ResponseDto<>(false, "Valid Error", null, errors);
        if (authorRepository.getAuthorById(bookDto.getAuthorId()) == null)
            return new ResponseDto<>(false,
                    String.format("Author with id: %s is not found",
                            bookDto.getAuthorId())
                    , null);
        try {
            Book book = BookMapper.toBook(bookDto);
            book.setLeftNumberOfBooks(book.getTotalNumberOfBooks());
            Book savedBook = bookRepository.addBook(book);
            return new ResponseDto<>(true,
                    String.format("Book with id %s is added", savedBook.getId()),
                    BookMapper.toBookDto(savedBook));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, "Save Error");
        }
    }

    public ResponseDto<BookDto> update(BookDto bookDto) {
        try {


            if (bookRepository.findById(bookDto.getId()) == null)
                return new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND);
            List<ValidDto> errors = Validation.checkBook(bookDto);
            if (errors.size() > 0)
                return new ResponseDto<>(false, AppMessage.VALID_ERROR, errors);

            bookRepository.updateBookById(bookDto.getId(), BookMapper.toBook(bookDto));
            return new ResponseDto<>(true, AppMessage.OK, bookDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, AppMessage.DATA_BASE_ERROR);
        }
    }

    public ResponseDto<String> delete(Integer id) {
        if (bookRepository.findById(id) == null)
            return new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND);
        bookRepository.deleteBookById(id);
        return new ResponseDto<>(true, AppMessage.OK, AppMessage.OK);
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
