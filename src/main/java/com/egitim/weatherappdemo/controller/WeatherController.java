package com.egitim.weatherappdemo.controller;

import com.egitim.weatherappdemo.model.GetWeatherResponse;
import com.egitim.weatherappdemo.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/get/weather/{cityName}")
    public String getWeather(@PathVariable String cityName, final Model model) {
        try {
            GetWeatherResponse getWeatherResponse = weatherService.getWeather(cityName);

            model.addAttribute("weather", getWeatherResponse);

            return "weather";

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @GetMapping("/home")
    public String goHomePage() {
        return "home";
    }

}
