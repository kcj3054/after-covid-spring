package com.example.aftercovidversion2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageSource messageSource;

    public ResponseEntity<?> message(Locale locale) {
        String result = messageSource.getMessage("hello", null, null, locale);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
