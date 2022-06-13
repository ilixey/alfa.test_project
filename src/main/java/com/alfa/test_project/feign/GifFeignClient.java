package com.alfa.test_project.feign;

import com.alfa.test_project.feign.dto.FeignGifsDto;
import com.alfa.test_project.feign.dto.FiegnRatesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gifs", url = "https://api.giphy.com/v1/gifs/search")
public interface GifFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    FeignGifsDto getGif(@RequestParam("api_key") String api_key, @RequestParam("q") String q);
}
