package com.egitim.weatherappdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WeatherController {

    @GetMapping("/get/weather")
    public void getWeather() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
