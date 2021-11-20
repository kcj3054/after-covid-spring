package com.example.aftercovidversion2.repository;

import com.example.aftercovidversion2.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository  extends JpaRepository<Director, Long> {

    Optional<Director> findByUsername(String username);
}
