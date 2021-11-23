package com.example.aftercovidversion2.repository;

import com.example.aftercovidversion2.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

}
