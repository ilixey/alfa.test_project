package com.alfa.test_project.feign;

import com.alfa.test_project.dto.GifsDto;
import com.alfa.test_project.feign.dto.FeignGifsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gifs", url = "https://api.giphy.com/v1")
public interface GifFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/gifs/search")
    FeignGifsDto getRichGif(@RequestParam("api_key") String app_id, @RequestParam("q") String str, @RequestParam("limit") int limit);
}
