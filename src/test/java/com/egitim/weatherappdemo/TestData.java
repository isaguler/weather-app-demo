package com.egitim.weatherappdemo;

import org.springframework.http.HttpHeaders;

public class TestData {

    public final String OPEN_WEATHER_MAP_BASE_URL = "weather-base-api-url?q=ankara&appid=api-key";

    public HttpHeaders getHttpHeaders() {
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("user-agent", org.springframework.http.HttpHeaders.USER_AGENT);

        return headers;
    }

    public static String requestedCity = "ankara";

    public String getAnkaraWeatherJson() {
        return """
                {
                    "coord": {
                        "lon": 32.8543,
                        "lat": 39.9199
                    },
                    "weather": [
                        {
                            "id": 803,
                            "main": "Clouds",
                            "description": "broken clouds",
                            "icon": "04d"
                        }
                    ],
                    "base": "stations",
                    "main": {
                        "temp": 283.7,
                        "feels_like": 282.04,
                        "temp_min": 283.26,
                        "temp_max": 284.73,
                        "pressure": 1011,
                        "humidity": 47
                    },
                    "visibility": 10000,
                    "wind": {
                        "speed": 6.17,
                        "deg": 270
                    },
                    "clouds": {
                        "all": 75
                    },
                    "dt": 1680780006,
                    "sys": {
                        "type": 2,
                        "id": 267643,
                        "country": "TR",
                        "sunrise": 1680751521,
                        "sunset": 1680797791
                    },
                    "timezone": 10800,
                    "id": 323786,
                    "name": "Ankara",
                    "cod": 200
                }
                """;
    }
}
