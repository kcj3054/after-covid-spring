package com.example.aftercovidversion2.service;

import com.example.aftercovidversion2.domain.User;
import com.example.aftercovidversion2.dto.CreateUserRequest;
import com.example.aftercovidversion2.dto.GetUserResponse;
import com.example.aftercovidversion2.exception.AfterCovidException;
import com.example.aftercovidversion2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@AllArgsConstructor
public class UserService {

    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional //변경
   public void createUserService(CreateUserRequest request) {
        userRepository.findByUsername(request.getUsername())
                .ifPresent(user -> {
                    throw new AfterCovidException("이미있는 이름입니다");
                });

        //패스워드 인코딩 ,
        String password = passwordEncoder.encode(request.getPassword());  // encode하면 복호화된 password가 나오게된다

        userRepository.save(
                User.builder()
                        .username(request.getUsername())
                        .password(password)
                        .build()
        );
    }

    public GetUserResponse getUserByUserId(Long userId) {
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



    /**
     * 회원 조회
     */

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(String username)
    {
        return Optional.ofNullable(userRepository.findByUsername(username)
                .orElseThrow(() -> new AfterCovidException("사용자 정보 없음")));

    }

//    /**
//     * 회원가입
//     */
//    @Transactional //변경
//    public Long join(User user) {
//
//        // 예외처리 로직 이미 맴버가 있을 경우 DuplicateUser(user);
//       userRepository.findByUsername(user.getUsername())
//                       .ifPresent( u -> {
//                           throw new AfterCovidException("중복된 username입니다");
//                       });
//
//        userRepository.save(user);
//        return user.getId();
//    }


}
