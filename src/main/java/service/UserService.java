package service;


import entity.User;
import model.LoginUserDto;
import model.ResponseDto;
import repository.BookRepository;
import repository.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public ResponseDto registerUser(User user) {

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


}
