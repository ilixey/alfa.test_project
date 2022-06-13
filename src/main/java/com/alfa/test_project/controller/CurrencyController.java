package com.alfa.test_project.controller;


import com.alfa.test_project.dto.CurrencyDto;
import com.alfa.test_project.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/currencies-rates")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping()
    public CurrencyDto getLatestRateByCurrencyCode(@RequestParam String code){
        return currencyService.getLatestRateByCurrencyCode(code);
    }

    @GetMapping("/historical")
    public CurrencyDto getRateByDate(@RequestParam String code){
        return currencyService.getRateByDate(code);
    }
}
