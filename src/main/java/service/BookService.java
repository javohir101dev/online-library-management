package service;

import entity.Book;
import mapper.BookMapper;
import model.BookDto;
import model.ResponseDto;
import model.ValidDto;
import repository.AuthorRepository;
import repository.BookRepository;

import java.util.List;

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
            Book savedBook = bookRepository.addBook(book);
            return new ResponseDto<>(true, "Ok", BookMapper.bookDto(book));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, "Save Error");
        }
    }
}
