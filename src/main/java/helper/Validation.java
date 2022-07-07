package helper;

import model.BookDto;
import model.ValidDto;
import repository.AuthorRepository;

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

}
