package com.example.aftercovidversion2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DetailController {

    @GetMapping("/detail")
    public String getPageDetail(){
        return "detail";
    }
}
