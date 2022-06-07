package com.alfa.test_project.service;

import com.alfa.test_project.dto.GifsDto;
import com.alfa.test_project.feign.GifFeignClient;
import com.alfa.test_project.feign.dto.FeignGifsDto;
import com.alfa.test_project.feign.dto.GifsObjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GifsService {

    @Value("${GIF_ID}")
    private String GIF_ID;

    private final GifFeignClient gifFeignClient;

    public GifsDto getRich() {
        FeignGifsDto feignGifsDto = gifFeignClient.getRichGif(GIF_ID, "rich", 2);
        System.out.println(feignGifsDto);
        GifsObjectDto gifsObjectDto = feignGifsDto.getData().get(0);
        return new GifsDto(gifsObjectDto.getSlug(), gifsObjectDto.getEmbed_url());

    }
}
