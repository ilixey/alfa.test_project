package com.alfa.test_project.service;

import com.alfa.test_project.dto.CurrencyDto;
import com.alfa.test_project.feign.CurrencyFeignClient;
import com.alfa.test_project.feign.dto.FiegnRatesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class CurrencyService {

    @Value("${APP_ID}")
    private String APP_ID;

    private final CurrencyFeignClient currencyFeignClient;

    public CurrencyDto getLatestRateByCurrencyCode(String code) {
        FiegnRatesDto rateByCode = currencyFeignClient.getRateByCode(APP_ID, code);
        return new CurrencyDto(code, rateByCode.getRates().get(code));
    }

    public CurrencyDto getRateByDate(String code) {
        String date = LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        System.out.println(date);
        FiegnRatesDto rateByDate = currencyFeignClient.getRateByDate(APP_ID, code, date);
        return new CurrencyDto(code, rateByDate.getRates().get(code));
    }
}
