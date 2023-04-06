package com.egitim.weatherappdemo.service;

import com.egitim.weatherappdemo.configuration.Constants;
import com.egitim.weatherappdemo.model.GetWeatherResponse;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@CacheConfig(cacheNames = {"weather-data"})
public class WeatherService {

    private final RestTemplate restTemplate;
    Gson gson = new Gson();

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(key = "#cityName")
    public GetWeatherResponse getWeather(String cityName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", HttpHeaders.USER_AGENT);

        String url = Constants.OPEN_WEATHER_MAP_BASE_URL +
                Constants.OPEN_WEATHER_MAP_QUERY_PARAM + cityName +
                Constants.OPEN_WEATHER_MAP_APPID_PARAM + Constants.API_KEY;

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        log.info("response: " + response);

        return response.getStatusCode().is2xxSuccessful() && response.getBody() != null && response.hasBody()
                ? gson.fromJson(response.getBody(), GetWeatherResponse.class)
                : new GetWeatherResponse();
    }

    @CacheEvict(allEntries = true)
    @PostConstruct
    @Scheduled(fixedRateString = "600000") // 10 MIN
    public void clearCache(){
        log.info("Caches are cleared");
    }
}
