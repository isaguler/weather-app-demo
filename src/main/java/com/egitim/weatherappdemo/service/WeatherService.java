package com.egitim.weatherappdemo.service;

import com.egitim.weatherappdemo.model.GetWeatherResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherService {

    @Value("${openweathermap.apikey}")
    String apiKey;

    Gson gson = new Gson();

    public GetWeatherResponse getWeather(String cityName) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", HttpHeaders.USER_AGENT);

        ResponseEntity<String> response = restTemplate.exchange("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        log.info("response: " + response);

        GetWeatherResponse getWeatherResponse = gson.fromJson(response.getBody(), GetWeatherResponse.class);

        return getWeatherResponse;
    }
}
