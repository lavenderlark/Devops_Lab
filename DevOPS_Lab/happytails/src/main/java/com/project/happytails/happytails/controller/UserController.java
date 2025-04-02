package com.project.happytails.happytails.controller;

import com.project.happytails.happytails.domain.User;
import com.project.happytails.happytails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // for frontend access
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User loginRequest) {
        return userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
