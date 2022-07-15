package repository;

import entity.Author;
import model.AuthorDto;
import model.ResponseDto;

import java.util.List;

public interface AuthorRepository {

    //    CREATE
    public Author addAuthor(Author author);

    //     READ
    public List<Author> getAllAuthors();

    /**
     * @param authorId
     * @return Author or null
     * returns null if author with given id is not found
     */
    public Author findById(Integer authorId);

    //    UPDATE
    /**
     * Updates author by id
     * @param authorId
     * @param author
     * @return null if author is not found with given is otherwise updates
     */
    public Author updateAuthorById(Integer authorId, Author author);

//    DELETE
    /**
     * Deletes author by id
     * @param authorId authorId
     * @return boolean
     * returns true if author is deleted otherwise false
     */

    public boolean deleteAuthorById(Integer authorId);

    /**
     * Returns bookId by author(id author is used in that book) id otherwise null
     * @param authorId id of author
     * @return bookId or null
     */
    public Integer authorBookWithAuthorId(Integer authorId);


    /**
     * Resturns book dto due to given search result
     * @param search any word
     * @return AuthorDto
     */
    List<Author> findAllAuthorsSearch(String search);
}
