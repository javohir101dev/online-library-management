package service;


import entity.User;
import entity.enums.Roles;
import helper.Validation;
import model.LoginUserDto;
import model.ResponseDto;
import model.UserUpdateDto;
import model.ValidDto;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import java.util.List;

public class UserService {

    UserRepository userRepository = UserRepositoryImpl.getInstance();

    public ResponseDto registerUser(User user) {

        List<ValidDto> validDtos = Validation.validateUser(user);
        if (validDtos.size() > 0) {
            return new ResponseDto(false, validDtos.toString());
        }

        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if (userByUsername != null) {
            return new ResponseDto("User with this username is already registered");
        }
        User savedUser = userRepository.addUser(user);
        return new ResponseDto(true, "User is saved successfully", savedUser);
    }

    public ResponseDto loginService(LoginUserDto loginUserDto) {

        User userByUsername = userRepository.findUserByUsername(loginUserDto.getUsername());
        if (userByUsername == null ||
                !userByUsername.getPassword().equals(loginUserDto.getPassword())) {
            return new ResponseDto(false, "Username or password wrong", null);
        }
        return new ResponseDto<>(true, null, userByUsername);
    }

    public ResponseDto editUser(UserUpdateDto dto) {
        List<ValidDto> validDtos = Validation.checkUserUpdateDto(dto);
        if (validDtos.size() > 0) {
            return new ResponseDto(false, validDtos.toString());
        }
        User userByNewUsername = userRepository.findUserByUsername(dto.getNewUsername());
        if (userByNewUsername != null) {
            return new ResponseDto(String
                    .format("User with this: %s username is already taken", dto.getNewUsername()));
        }
        User userByOldUsername = userRepository.findUserByUsername(dto.getOldUsername());
        if (userByOldUsername == null) {
            return new ResponseDto(String
                    .format("User with this username: %s not found, please enter your old username correctly", dto.getOldUsername()));
        }
        User user = User.builder()
                .id(userByOldUsername.getId())
                .firstname(dto.getFirstname())
                .lastName(dto.getLastName())
                .username(dto.getNewUsername())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .role(Roles.USER.name())
                .build();
        User savedUser = userRepository.updateUserById(userByOldUsername.getId(), user);
        return new ResponseDto(true, "User is edited successfully", savedUser);
    }

}
