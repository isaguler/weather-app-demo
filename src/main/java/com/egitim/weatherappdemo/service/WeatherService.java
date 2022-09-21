package com.egitim.weatherappdemo.service;

import com.egitim.weatherappdemo.model.GetWeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherService {

    String apiKey = "51fdbe96964e1511c09360b3870b9ab2";

    ObjectMapper objectMapper = new ObjectMapper();

    Gson gson = new Gson();

    public GetWeatherResponse getWeather(String cityName) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", HttpHeaders.USER_AGENT);

        ResponseEntity<String> response = restTemplate.exchange("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        log.info("response: " + response);

        GetWeatherResponse getWeatherResponse = gson.fromJson(response.getBody(), GetWeatherResponse.class);

        log.info("visibility: " + getWeatherResponse.getVisibility());

        /*JSONObject jsonObject = objectMapper.convertValue(response.getBody(), JSONObject.class);
        log.info("json: " + jsonObject);

        Integer visibility = jsonObject.getInt("visibility");
        log.info("visibility: " + visibility);*/

        //return response.getBody();

        return getWeatherResponse;
    }
}
