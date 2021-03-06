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


    /***
     * 다이어리에서 필요한 서비스로직 구현 ..
     */

}
