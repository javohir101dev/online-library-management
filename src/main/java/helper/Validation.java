package helper;

import entity.User;
import helper.messages.AppMessage;
import model.AuthorDto;
import model.BookDto;
import model.UserUpdateDto;
import model.ValidDto;
import repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

import static helper.IntegerHelper.isDigit;
import static helper.messages.AppMessage.*;

public class Validation {
    private AuthorRepository authorRepository = new AuthorRepository();

    public static List<ValidDto> checkAllIntegers(BookDto bookDto) {
        List<ValidDto> errors = new ArrayList<>();

        if (!isDigit(String.valueOf(bookDto.getAuthorId()))) {
            errors.add(new ValidDto("authorId", IS_NOT_DIGIT));
        } else if (!isDigit(String.valueOf(bookDto.getTotalNumberOfBooks()))) {
            errors.add(new ValidDto("totalNumberOfBooks", IS_NOT_DIGIT));
        } else if (!isDigit(String.valueOf(bookDto.getPageCount()))) {
            errors.add(new ValidDto("pageCount", IS_NOT_DIGIT));
        }
        return errors;
    }

    public static List<ValidDto> checkIsNegative(BookDto bookDto) {
        List<ValidDto> errors = new ArrayList<>();

        if (bookDto.getAuthorId() < 1) {
            errors.add(new ValidDto("AuthorId", NEGATIVE_ERROR));
        } else if
        (bookDto.getCost() < 1) {
            errors.add(new ValidDto("Cost", NEGATIVE_ERROR));
        } else if (bookDto.getTotalNumberOfBooks() < 1) {
            errors.add(new ValidDto("totalNumberOfBooks", NEGATIVE_ERROR));
        } else if (bookDto.getPageCount() < 1) {
            errors.add(new
                    ValidDto("pageCount", NEGATIVE_ERROR));
        }
        return errors;
    }


    public static List<ValidDto> checkAuthorDto(AuthorDto authorDto) {
        List<ValidDto> errors = new ArrayList<>();

        if (authorDto.getFirstname() == null)
            errors.add(new ValidDto("firstName", EMPTY));
        else if (authorDto.getFirstname().trim().equals(""))
            errors.add(new ValidDto("firstName", EMPTY));

        if (authorDto.getLastName() == null)
            errors.add(new ValidDto("lastName", EMPTY));
        else if (authorDto.getLastName().trim().equals(""))
            errors.add(new ValidDto("lastName", EMPTY));
        if (!DateHelper.checkDate(String.valueOf(authorDto.getBirthDate())))
            errors.add(new ValidDto("birthDate", AppMessage.DATE_FORMAT_ERROR));
        return errors;
    }

    public static List<ValidDto> checkBook(BookDto bookDto) {
        List<ValidDto> errors = new ArrayList<>();
        if (bookDto.getName().trim().equals(""))
            errors.add(new ValidDto("name", EMPTY));
        else if (bookDto.getName() == null) {
            errors.add(new ValidDto("name", EMPTY));
        } else if (bookDto.getGenre().trim().equals("")) {
            errors.add(new ValidDto("genre", EMPTY));
        } else if (bookDto.getGenre() == null)
            errors.add(new ValidDto("genre", EMPTY));
        return errors;
    }

    public static List<ValidDto> checkUserUpdateDto(UserUpdateDto dto) {
        List<ValidDto> errors = new ArrayList<>();
        if (!StringHelper.isValid(dto.getFirstname())) {
            errors.add(new ValidDto("firstname", EMPTY));
        } else if (!StringHelper.isValid(dto.getLastName())) {
            errors.add(new ValidDto("lastName", EMPTY));
        } else if (!StringHelper.isValid(dto.getOldUsername())) {
            errors.add(new ValidDto("oldUsername", EMPTY));
        } else if (!StringHelper.isValid(dto.getNewUsername())) {
            errors.add(new ValidDto("newUsername", EMPTY));
        } else if (!StringHelper.isValid(dto.getPhoneNumber())) {
            errors.add(new ValidDto("phoneNumber", EMPTY));
        } else if (!StringHelper.isValid(dto.getPassword())) {
            errors.add(new ValidDto("password", EMPTY));
        }
        return errors;
    }

    public static List<ValidDto> validateUser(User user) {
        List<ValidDto> errors = new ArrayList<>();

        if (!StringHelper.isValid(user.getFirstname())) {
            errors.add(new ValidDto("firstname", EMPTY));
        } else if (!StringHelper.isValid(user.getLastName())) {
            errors.add(new ValidDto("lastName", EMPTY));
        } else if (!StringHelper.isValid(user.getUsername())) {
            errors.add(new ValidDto("username", EMPTY));
        } else if (!StringHelper.isValid(user.getPhoneNumber())) {
            errors.add(new ValidDto("phoneNumber", EMPTY));
        } else if (!StringHelper.isValid(user.getPassword())) {
            errors.add(new ValidDto("password", EMPTY));
        }
        return errors;
    }


}
