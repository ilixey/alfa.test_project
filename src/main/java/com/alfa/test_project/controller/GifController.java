package com.alfa.test_project.controller;

import com.alfa.test_project.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/getGif")
public class GifController {

    private final GifService gifService;
    private final CurrencyController currencyController;

    @GetMapping()
    public ResponseEntity<Void> getGif(){
        //currencyController.getLatestRateByCurrencyCode();
        String url = gifService.getGif("broke").getEmbed_url();
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
    }
}
