package com.alfa.test_project.service;

import com.alfa.test_project.dto.GifDto;
import com.alfa.test_project.feign.GifFeignClient;
import com.alfa.test_project.feign.dto.FeignGifsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GifService {

    @Value("${GIF_ID}")
    private String api_key;

    private final GifFeignClient gifFeignClient;

    public GifDto getGif(String q) {
        FeignGifsDto feignGifsDto = gifFeignClient.getGif(api_key, q);
        return new GifDto(feignGifsDto.getData().get(new Random().nextInt(0,25)).getEmbed_url());
    }
}
