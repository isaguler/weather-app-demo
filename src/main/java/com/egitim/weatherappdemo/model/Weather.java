package com.egitim.weatherappdemo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Weather {

    public int id;
    public String main;
    public String description;
    public String icon;
}
