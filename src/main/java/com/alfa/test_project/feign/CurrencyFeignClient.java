package com.alfa.test_project.feign;

import com.alfa.test_project.feign.dto.FiegnRatesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "currenciesRates", url = "https://openexchangerates.org")
public interface CurrencyFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/latest.json")
    FiegnRatesDto getRateByCode(@RequestParam("app_id") String app_id, @RequestParam("symbols") String code);

    @RequestMapping(method = RequestMethod.GET, value = "/api/historical/{date}.json")
    FiegnRatesDto getRateByDate(@RequestParam("app_id") String app_id, @RequestParam("symbols") String code, @PathVariable String date);

}
