package com.example.aftercovidversion2.security;

import com.example.aftercovidversion2.domain.User;
import com.example.aftercovidversion2.exception.AfterCovidException;
import com.example.aftercovidversion2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{


    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AfterCovidException("username을 찾을 수 없습니다"));

        return new UserDetailsImpl(user);
    }
}
