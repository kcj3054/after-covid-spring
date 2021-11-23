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
    private final DirectorRepository directorRepository;
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

    @GetMapping
    public String home() {
        //jwt 토큰 관련..
    }

    @GetMapping("/sign-in")
    public  String signIn() {
        //아이디 비밀번호가 낭라오면, 로그인 처리  아이디 찾지못하면 일치않는다..
    }

}
