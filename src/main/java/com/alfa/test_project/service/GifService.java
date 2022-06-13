package com.alfa.test_project.service;

import com.alfa.test_project.dto.GifDto;
import com.alfa.test_project.feign.GifFeignClient;
import com.alfa.test_project.feign.dto.FeignGifsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class GifService {

    public final String api_key = "F0u2rKqJ04NA7zZfnOhM0sbV3qxKxGe7";
    private final GifFeignClient gifFeignClient;

    public GifDto getGif(String q) {
        FeignGifsDto feignGifsDto = gifFeignClient.getGif(api_key, q);
        return new GifDto(feignGifsDto.getData().get(new Random().nextInt(0,25)).getEmbed_url());
    }
}
