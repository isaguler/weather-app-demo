package com.egitim.weatherappdemo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WeatherSys {

    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}
