package mapper;

import entity.Genre;
import model.GenreDto;

public class GenreMapper {
    public static GenreDto toDto(Genre genre) {
        return genre == null ? null : GenreDto
                .builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

    public static Genre toEntity(GenreDto genreDto) {
        return genreDto == null ? null : Genre
                .builder()
                .id(genreDto.getId())
                .name(genreDto
                        .getName())
                .build();
    }
}
