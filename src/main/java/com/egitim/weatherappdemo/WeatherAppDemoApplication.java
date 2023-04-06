package com.egitim.weatherappdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppDemoApplication.class, args);
	}

}
