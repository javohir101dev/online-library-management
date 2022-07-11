package repository;

import entity.Genre;
import helper.Validation;
import helper.messages.AppMessage;
import mapper.GenreMapper;
import model.GenreDto;
import model.ResponseDto;
import model.ValidDto;

import java.util.List;
import java.util.stream.Collectors;

import static helper.messages.AppMessage.ERROR;

public class GenreService {
    private GenreRepository genreRepository = new GenreRepository();

    public ResponseDto<GenreDto> addGenre(GenreDto genreDto) {
        try {
            genreDto.setId(null);
            List<ValidDto> errors = Validation.checkGenre(genreDto);
            if (errors.size() > 0) {
                return new ResponseDto<>(false, AppMessage.VALID_ERROR, genreDto, errors);
            }

            Genre genre = GenreMapper.toEntity(genreDto);
            Genre genreByName = genreRepository.getGenreByName(genreDto.getName());
            if (genreByName != null) {
                return new ResponseDto<>(false, String.format("Genre with name: %s is already exists", genreDto.getName()));
            } else {
                genre = genreRepository.addGenre(genre);
                return new ResponseDto<>(true, "Genre is added successfully", GenreMapper.toDto(genre));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, AppMessage.SAVE_ERROR);
        }
    }


    public ResponseDto<GenreDto> update(GenreDto genreDto) {
        List<ValidDto> errors = Validation.checkGenre(genreDto);
        if (errors.size() > 0) {
            return new ResponseDto<>(false, errors.toString());
        }
        Genre genre = GenreMapper.toEntity(genreDto);
        Genre genreById = genreRepository.findById(genre.getId());
        if (genreById == null) {
            return new ResponseDto<>(false, String
                    .format("Genre with id: %s is not found", genreDto.getId()));
        }
        Genre genreByName = genreRepository.getGenreByName(genreDto.getName());
        if (genreByName != null) {
            return new ResponseDto<>(false, String
                    .format("Genre with name: %s is already exists", genreDto.getName()));
        }


        genre = genreRepository.updateGenre(genre);
        if (genre != null) {
            return new ResponseDto<>(true, "Genre is edited successfully", GenreMapper.toDto(genre));
        }
        return new ResponseDto<>(false, String
                .format("Genre with id %s is not found", genre.getId()));
    }


    public ResponseDto<Boolean> delete(Integer genreId) {
        Genre genre = genreRepository.findById(genreId);
        if (genre == null) {
            return new ResponseDto<>(false, String
                    .format("Genre with id: %s is not found", genreId));
        }
        Integer bookIdByGenreId = genreRepository.getBookIdByGenreId(genre.getId());
        if (bookIdByGenreId != null) {
            return new ResponseDto<>(false, String
                    .format("Genre with id: %s is used in book with id: %s. First delete book with id: %s",
                            genre.getId(), bookIdByGenreId, bookIdByGenreId));
        }
        boolean access = genreRepository.deleteGenre(genreId);
        if (access) {
            return new ResponseDto<>(true, "Genre is deleted successfully", true);
        }
       return new ResponseDto<>(false, ERROR);
    }


    public ResponseDto<GenreDto> getById(Integer id) {
        Genre genre = genreRepository.findById(id);
        if (genre != null) {
            return new ResponseDto<>(true, AppMessage.OK, GenreMapper.toDto(genre));
        }
        return new ResponseDto<>(false, AppMessage.ID_IS_NOT_FOUND);
    }


    public ResponseDto<List<GenreDto>> getAll() {
        List<GenreDto> genreDtos = genreRepository.getAll().stream()
                .map(GenreMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseDto<>(true, AppMessage.OK, genreDtos);
    }
}
