package com.example.aftercovidversion2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User {


    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRole role;
}
