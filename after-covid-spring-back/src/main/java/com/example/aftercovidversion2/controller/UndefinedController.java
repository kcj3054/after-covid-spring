package com.example.aftercovidversion2.controller;


import com.example.aftercovidversion2.domain.Diary;
import com.example.aftercovidversion2.repository.DiaryRepository;
import com.example.aftercovidversion2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UndefinedController {

    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;


    @GetMapping
    public String Main() {
        return "index";
    }

    @PostMapping("/save-diary")
    public void saveDiary(String title, String content) {
        diaryRepository.save(
                Diary.builder()
                        .title(title)
                        .content(content)
                        .build()
        );
    }

}
