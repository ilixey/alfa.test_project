package com.alfa.test_project.feign.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import java.util.List;

@lombok.Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeignGifsDto {
    List<FeignDataOfGifDto> data;
}
