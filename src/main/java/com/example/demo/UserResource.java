package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UserResource.USER)
public class UserResource {
    public static final String USER = "/users";
    UserController userController;

    @Autowired
    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @GetMapping
    private List<User> users() {
        return userController.readAll();
    }

//    @GetMapping("/{id}")
//    private User user(@PathVariable String id) {
//        return userController.getUserById(id);
//    }
//
//    @GetMapping("/{id}/email}")
//    private Map<String,String> email(@PathVariable String id) {
//        return Collections.singletonMap("email",userController.getUserById(id).getEmail());
//    }
}
