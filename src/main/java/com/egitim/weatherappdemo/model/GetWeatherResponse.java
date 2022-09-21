package com.egitim.weatherappdemo.model;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GetWeatherResponse {

    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public WeatherMain main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public WeatherSys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;

}
