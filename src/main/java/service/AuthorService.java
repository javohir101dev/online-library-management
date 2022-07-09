package service;

import entity.Author;
import helper.Validation;
import helper.messages.AppMessage;
import mapper.AuthorMapper;
import model.AuthorDto;
import model.ResponseDto;
import model.ValidDto;
import mapper.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

import static helper.Validation.checkAuthorDto;

public class AuthorService {
    private AuthorRepository authorRepository;
    public ResponseDto<AuthorDto> addBook(AuthorDto authorDto) {
        List<ValidDto> errors = checkAuthorDto(authorDto);
        if (errors.size() > 0)
            return new ResponseDto<>(false, AppMessage.VALID_ERROR, null, errors);

        try {
            Author author = AuthorMapper.toEntity(authorDto);
           Author author1= authorRepository.addAuthor(author);
            return new ResponseDto<>(true, AppMessage.OK, AuthorMapper.toDto(author1));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, AppMessage.SAVE_ERROR);
        }
    }
    public ResponseDto<AuthorDto> update(AuthorDto authorDto)
    {
        try {
            if (authorRepository.finfById(authorDto.getId()) == null)
                return new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND);
            List<ValidDto> errors = Validation.checkAuthorDto(authorDto);
            if (errors.size() > 0)
                return new ResponseDto<>(false, AppMessage.VALID_ERROR, errors);

            Author author = authorRepository.updateAuthorById(authorDto.getId(), AuthorMapper.toEntity(authorDto));
            return new ResponseDto<>(true, AppMessage.OK, AuthorMapper.toDto(author));
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseDto<>(false,AppMessage.DATA_BASE_ERROR);
        }
    }
    public ResponseDto<String> delete(Integer id)
    {
       if(authorRepository.finfById(id)==null)
            return new ResponseDto<>(false,AppMessage.ID_IS_NOT_FOUND);
       authorRepository.deleteAuthorById(id);
       return new ResponseDto<>(true, AppMessage.OK);
    }
    public ResponseDto<List<AuthorDto>> getAll()
    {
        List<Author> authorList = authorRepository.getAllAuthors();
        List<AuthorDto> authorDtos =authorList.stream()
                .map(AuthorMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseDto<>(true, AppMessage.OK,authorDtos);
    }
    public ResponseDto<AuthorDto> getById(Integer id)
    {
        Author author=authorRepository.finfById(id);
        return author == null ? new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND) :
                new ResponseDto<>(true, AppMessage.OK,AuthorMapper.toDto(author));
    }
}
