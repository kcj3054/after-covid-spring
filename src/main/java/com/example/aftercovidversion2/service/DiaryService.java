package com.example.aftercovidversion2.service;


import com.example.aftercovidversion2.repository.DiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@AllArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;


}
