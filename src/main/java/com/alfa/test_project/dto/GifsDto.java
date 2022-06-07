package com.alfa.test_project.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@RequiredArgsConstructor
public class GifsDto {
    private final String name;
    private final String url;
}
