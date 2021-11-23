package com.example.aftercovidversion2.controller;

import com.example.aftercovidversion2.domain.User;
import com.example.aftercovidversion2.dto.CreateUserRequest;
import com.example.aftercovidversion2.dto.GetUserResponse;
import com.example.aftercovidversion2.exception.AfterCovidException;
import com.example.aftercovidversion2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;


    @PostMapping
    public void createUser(@RequestBody CreateUserRequest request) {

        userRepository.findByUsername(request.getUsername())
                .ifPresent(user -> {
                    throw new AfterCovidException("이미있는 이름입니다");
                });

        userRepository.save(
                User.builder()
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .build()
        );
    }


    @GetMapping("/{userId}")
    public GetUserResponse getUserByUserId(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user ->
                        GetUserResponse
                                .builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .build()
                )
                .orElseThrow(() -> new AfterCovidException("유저 정보 없음"));
    }

}
