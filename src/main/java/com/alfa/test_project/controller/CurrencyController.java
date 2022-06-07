package com.alfa.test_project.controller;


import com.alfa.test_project.dto.CurrencyDto;
import com.alfa.test_project.dto.GifsDto;
import com.alfa.test_project.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/currency-rates")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public CurrencyDto getLatestRateByCurrencyCode(@RequestParam String code){
        return currencyService.getLatestRateByCurrencyCode(code);
    }

    @GetMapping("/historical")
    public CurrencyDto getRateByDate(@RequestParam String code){
        return currencyService.getRateByDate(code);
    }
}
