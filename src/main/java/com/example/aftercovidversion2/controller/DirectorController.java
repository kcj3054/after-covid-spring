package com.example.aftercovidversion2.controller;


import com.example.aftercovidversion2.dto.DirectResponse;
import com.example.aftercovidversion2.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorRepository directorRepository;


    @GetMapping("/directorId")
    public DirectResponse getDirectById(@PathVariable Long DirectId) {
        return directorRepository.findById(DirectId)
                .map(direct ->
                                DirectResponse
                                        .builder()
                                        .username(direct.getUsername())
                                        .build()
                        )
    }

}
