package mapper;

import entity.Book;
import model.BookDto;

public class BookMapper {

    public static Book toBook(BookDto bookDto) {
        return bookDto == null ? null :  Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .cost(bookDto.getCost())
                .genre(bookDto.getGenre())
                .pageCount(bookDto.getPageCount())
                .totalNumberOfBooks(bookDto.getTotalNumberOfBooks())
                .leftNumberOfBooks(bookDto.getLeftNumberOfBooks())
                .authorId(bookDto.getAuthorId()).build();
    }

    public static BookDto bookDto(Book book){
        return book == null ? null :BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .cost(book.getCost())
                .genre(book.getGenre())
                .pageCount(book.getPageCount())
                .totalNumberOfBooks(book.getTotalNumberOfBooks())
                .leftNumberOfBooks(book.getLeftNumberOfBooks())
                .authorId(book.getAuthorId()).build();
    }

}
