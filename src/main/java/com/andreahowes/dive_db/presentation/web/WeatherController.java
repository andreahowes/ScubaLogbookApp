package com.andreahowes.dive_db.presentation.web;

import com.andreahowes.dive_db.logic.weather.Weather;
import com.andreahowes.dive_db.logic.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("location/{location}")
    private Weather getWeatherFromLocation(@PathVariable String location) {
        Weather weather = weatherService.getWeatherFromLocation(location);
        return weather;

    }


}
