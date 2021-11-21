package com.example.aftercovidversion2.service;

import com.example.aftercovidversion2.domain.User;
import com.example.aftercovidversion2.exception.AfterCovidException;
import com.example.aftercovidversion2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@AllArgsConstructor
public class UserService {

    private  final UserRepository userRepository;


    /**
     * 회원가입
     */
    @Transactional //변경
    public Long join(User user) {

        // 예외처리 로직 이미 맴버가 있을 경우 DuplicateUser(user);
       userRepository.findByUsername(user.getUsername())
                       .ifPresent( u -> {
                           throw new AfterCovidException("중복된 username입니다");
                       });

        userRepository.save(user);
        return user.getId();
    }

    /**
     * 회원 조회
     */

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AfterCovidException("사용자 정보 없음")));
    }
}
