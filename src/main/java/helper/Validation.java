package helper;

import helper.messages.AppMessage;
import model.AuthorDto;
import model.BookDto;
import model.ValidDto;
import mapper.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

import static helper.IntegerHelper.isDigit;
import static helper.messages.AppMessage.IS_NOT_DIGIT;
import static helper.messages.AppMessage.NEGATIVE_ERROR;

public class Validation {
    private AuthorRepository authorRepository = new AuthorRepository();
    public static List<ValidDto> checkAllIntegers(BookDto bookDto)
    {
        List<ValidDto> errors = new ArrayList<>();

        if(!isDigit(String.valueOf(bookDto.getAuthorId())))
            errors.add(new ValidDto("authorId", IS_NOT_DIGIT));

        if(!isDigit(String.valueOf(bookDto.getTotalNumberOfBooks())))
            errors.add(new ValidDto("totalNumberOfBooks",IS_NOT_DIGIT));

        if(!isDigit(String.valueOf(bookDto.getPageCount())))
            errors.add(new ValidDto("pageCount",IS_NOT_DIGIT));
        return errors;
    }
    public static List<ValidDto> checkIsNegative(BookDto bookDto)
    {
        List<ValidDto> errors = new ArrayList<>();

        if(bookDto.getAuthorId()<1)
            errors.add(new ValidDto("AuthorId",NEGATIVE_ERROR));

        if(bookDto.getCost()<1)
            errors.add(new ValidDto("Cost",NEGATIVE_ERROR));

        if(bookDto.getTotalNumberOfBooks()<1)
            errors.add(new ValidDto("totalNumberOfBooks",NEGATIVE_ERROR));

        if(bookDto.getPageCount()<1)
            errors.add(new ValidDto("pageCount",NEGATIVE_ERROR));
        return errors;
    }


    public static List<ValidDto> checkAuthorDto(AuthorDto authorDto)
    {
        List<ValidDto> errors = new ArrayList<>();

        if(authorDto.getFirstname() ==null)
            errors.add(new ValidDto("firstName", AppMessage.EMPTY));
        else if(authorDto.getFirstname().trim().equals(""))
            errors.add(new ValidDto("firstName", AppMessage.EMPTY));

        if(authorDto.getLastName() ==null)
            errors.add(new ValidDto("lastName",AppMessage.EMPTY));
        else if(authorDto.getLastName().trim().equals(""))
            errors.add(new ValidDto("lastName", AppMessage.EMPTY));
        if(DateHelper.checkDate(String.valueOf(authorDto.getBirthDate())))
            errors.add(new ValidDto("birthDate",AppMessage.DATE_FORMAT_ERROR));
        return errors;
    }
    public static List<ValidDto> checkBook(BookDto bookDto)
    {
        List<ValidDto> errors = new ArrayList<>();
        if(bookDto.getName().trim().equals(""))
            errors.add(new ValidDto("name",AppMessage.EMPTY));
        else if(bookDto.getName()==null)
            errors.add(new ValidDto("name",AppMessage.EMPTY));

        if(bookDto.getGenre().trim().equals(""))
            errors.add(new ValidDto("genre",AppMessage.EMPTY));
        else if(bookDto.getGenre()==null)
            errors.add(new ValidDto("genre",AppMessage.EMPTY));
        return errors;
    }


}
