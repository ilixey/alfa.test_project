package com.alfa.test_project.controller;

import com.alfa.test_project.dto.GifsDto;
import com.alfa.test_project.service.GifsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gifs")
@AllArgsConstructor
public class GifsController {

    private final GifsService gifsService;

    @GetMapping("/rich")
    public GifsDto getRichGif(){
        return gifsService.getRich();
    }
}
