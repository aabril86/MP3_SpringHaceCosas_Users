package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserController {

    UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> readAll() {
        return userDao.findAll();
    }

//    public User getUserById(String id) {
//    }
//
//    public void addUser(User user) {
//    }
}
