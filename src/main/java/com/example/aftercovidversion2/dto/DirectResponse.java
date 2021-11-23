package com.example.aftercovidversion2.dto;


import lombok.*;
import org.springframework.beans.factory.annotation.Required;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DirectResponse {

    private String username;
    private String password;

}
