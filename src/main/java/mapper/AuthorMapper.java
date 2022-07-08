package mapper;

import entity.Author;
import model.AuthorDto;

public class AuthorMapper {
    public static AuthorDto toDto(Author author)
    {
        return author==null ? null : AuthorDto.builder()
                .firstname(author.getFirstname())
                .lastName(author.getLastName())
                .birthDate(author.getBirthDate())
                .build();
    }
    public static Author toEntity(AuthorDto authorDto)
    {
        return authorDto == null ? null : Author.builder()
                .firstname(authorDto.getFirstname())
                .lastName(authorDto.getLastName())
                .birthDate(authorDto.getBirthDate())
                .build();
    }
}
