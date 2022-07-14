package service;

import entity.Author;
import helper.Validation;
import helper.messages.AppMessage;
import mapper.AuthorMapper;
import model.AuthorDto;
import model.ResponseDto;
import model.ValidDto;
import repository.AuthorRepository;
import repository.impl.AuthorRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

import static helper.Validation.checkAuthorDto;

public class AuthorService {
    private AuthorRepository authorRepository = AuthorRepositoryImpl.getInstance();

    public ResponseDto<AuthorDto> addAuthor(AuthorDto authorDto) {
        List<ValidDto> errors = checkAuthorDto(authorDto);
        if (errors.size() > 0)
            return new ResponseDto<>(false, AppMessage.VALID_ERROR, null, errors);

        try {
            Author author = AuthorMapper.toEntity(authorDto);
            Author savedAuthor = authorRepository.addAuthor(author);
            AuthorDto savedAuthorDto = AuthorMapper.toDto(savedAuthor);
            return new ResponseDto<>(true, String.
                    format("Author %s is successfully saved", savedAuthorDto),
                    savedAuthorDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, AppMessage.SAVE_ERROR);
        }
    }

    public ResponseDto<AuthorDto> update(AuthorDto authorDto) {
        try {
            if (authorRepository.findById(authorDto.getId()) == null)
                return new ResponseDto<>(false, String
                        .format("Author with id: %s is not found", authorDto.getId()));
            List<ValidDto> errors = Validation.checkAuthorDto(authorDto);
            if (errors.size() > 0)
                return new ResponseDto<>(false, AppMessage.VALID_ERROR, errors);
            Author author = authorRepository.updateAuthorById(authorDto.getId(),
                    AuthorMapper.toEntity(authorDto));
            return new ResponseDto<>(true, String
                    .format("Author with id: %s is edited successfully", author.getId()),
                    AuthorMapper.toDto(author));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, AppMessage.DATA_BASE_ERROR);
        }
    }

    public ResponseDto<String> delete(Integer authorId) {
        if (authorRepository.findById(authorId) == null) {
            return new ResponseDto<>(false, String
                    .format("Author with this id: %s is not found",
                            authorId));
        }
        Integer usedBookId = authorRepository.authorBookWithAuthorId(authorId);
        if (usedBookId != null) {
            return new ResponseDto<>(false, String
                    .format("Author with id: %s is used book with id: %s. Please first delete book with id: %s",
                            authorId, usedBookId, usedBookId));
        }
        boolean isDeleted = authorRepository.deleteAuthorById(authorId);
        if (isDeleted) {

            return new ResponseDto<>(true, String
                    .format("Author with id: %s is deleted", authorId));
        } else {
            return new ResponseDto<>(false, AppMessage.ERROR);
        }
    }

    public ResponseDto<List<AuthorDto>> getAll() {
        List<Author> authorList = authorRepository.getAllAuthors();
        List<AuthorDto> authorDtoList = authorList.stream()
                .map(AuthorMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseDto<>(true, AppMessage.OK, authorDtoList);
    }

    public ResponseDto<AuthorDto> getById(Integer id) {
        Author author = authorRepository.findById(id);
        return author == null ? new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND) :
                new ResponseDto<>(true, AppMessage.OK, AuthorMapper.toDto(author));
    }
}
