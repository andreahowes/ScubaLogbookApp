package com.andreahowes.dive_db.presentation;

import com.andreahowes.dive_db.logic.WeatherService;
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
    public WeatherController (WeatherService weatherService){
        this.weatherService=weatherService;
    }

    @GetMapping("location/{location}")
    private String getWeatherFromLocation(@PathVariable String location){
        //return weatherService.getWeatherFromLocation(location);
        //ApiWeather apiWeather=weatherService.getWeatherFromLocation(location);
        String theSunriseTime = weatherService.getTheSunriseTime(location);
        String theSunsetTime = weatherService.getTheSunsetTime(location);
        String tempInF = weatherService.getTheTempInF(location);
        String highTempF = weatherService.getTheHighTempF(location);;
        String lowTempF = weatherService.getTheLowTempF(location);;
        return "The current temperature in " + location + " is " + tempInF + " degrees Fahrenheit, with a high of " + highTempF + " degrees and a low of " +
                lowTempF +" degrees. The sunrise is at " + theSunriseTime + " and the sunset is at " + theSunsetTime + ". Plan your next dive accordingly!";
    }


}
