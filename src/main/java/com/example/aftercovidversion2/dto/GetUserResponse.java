package com.example.aftercovidversion2.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetUserResponse {

    private Long id;
    private String username;
    private String password;
}
