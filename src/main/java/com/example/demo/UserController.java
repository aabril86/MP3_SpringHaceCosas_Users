package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserController {

    UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserDto> readAll() {
        List<UserDto> users = userDao.findAll().stream().map(UserDto::new).collect(Collectors.toList());
        return users;
    }

    public UserDto getUserById(Integer id) {
        Optional<User> user = userDao.findById(id);

        if(user.isPresent()) return new UserDto(user.get());
        else return null;
    }

    public UserDto addUser(UserDto userDto) {
        User user = new User(userDto);

        userDao.save(user);

        return userDto;
    }

    public void removeUser(int id){
        userDao.deleteById(id);
    }

    public UserDto updateUser(UserDto userDto, Integer id) {
        User user = new User(userDto);
        return userDao.findById(id).map(u -> {
            u.setEmail(user.getEmail());
            u.setFullName(user.getFullName());
            u.setPassword(user.getPassword());

            userDao.save(u);

            return new UserDto(u);
        }).orElseGet(() -> {
            UserDto userDto1 = new UserDto(userDao.save(user));
            return userDto1;
        });
    }
}
