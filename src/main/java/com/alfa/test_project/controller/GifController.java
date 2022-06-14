package com.alfa.test_project.controller;

import com.alfa.test_project.service.CurrencyService;
import com.alfa.test_project.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/getGif")
public class GifController {

    private final GifService gifService;
    private final CurrencyService currencyService;

    @GetMapping("")
    public ResponseEntity<Void> getGif(@RequestParam String code){
        String typeOfGif = (currencyService.getLatestRateByCurrencyCode(code).compareTo(currencyService.getRateByDate(code)) == 1)?"rich":"broke";
        String url = gifService.getGif(typeOfGif).getEmbed_url();
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
    }
}
