package com.alfa.test_project.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class CurrencyDto {
    private final String name;
    private final BigDecimal rate;
}
