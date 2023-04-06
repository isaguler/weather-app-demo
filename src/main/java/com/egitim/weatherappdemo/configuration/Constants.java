package com.egitim.weatherappdemo.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Constants {

    public static String OPEN_WEATHER_MAP_BASE_URL;

    public static final String OPEN_WEATHER_MAP_QUERY_PARAM = "?q=";

    public static final String OPEN_WEATHER_MAP_APPID_PARAM = "&appid=";

    public static String API_KEY;

    @Value("${open-weather-map.api-url}")
    public void setOpenWeatherMapBaseUrl(String apiUrl) {
        Constants.OPEN_WEATHER_MAP_BASE_URL = apiUrl;
    }

    @Value("${open-weather-map.api-key}")
    public void setApiKey(String apiKey) {
        API_KEY = apiKey;
    }
}
