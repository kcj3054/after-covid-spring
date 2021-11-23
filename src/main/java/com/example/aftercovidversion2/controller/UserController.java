package com.example.aftercovidversion2.controller;

import com.example.aftercovidversion2.domain.User;
import com.example.aftercovidversion2.dto.CreateUserRequest;
import com.example.aftercovidversion2.dto.GetUserResponse;
import com.example.aftercovidversion2.exception.AfterCovidException;
import com.example.aftercovidversion2.repository.UserRepository;
import com.example.aftercovidversion2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody CreateUserRequest request) {
        userService.createUserService(request);
    }

    @GetMapping("/{userId}")
    public GetUserResponse getUserByUserId(@PathVariable Long userId) {
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{username}")
    public Optional<User>  findOne(@PathVariable String username) {
        return userService.findOne(username);
    }

}
