package com.andreahowes.dive_db.logic;


import com.andreahowes.dive_db.data.ApiWeather;
import com.andreahowes.dive_db.data.ApiWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WeatherService {

    private ApiWeatherRepository weatherRepository;

    @Autowired
    public WeatherService(ApiWeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public ApiWeather getWeatherFromLocation(String location) {
        //    return weatherRepository.getWeather(location);
        ApiWeather apiWeather = weatherRepository.getWeather(location);
        apiWeather.getName();
        apiWeather.getMain().getHumidity();
        apiWeather.getMain().getTemp();
        apiWeather.getMain().getTemp_max();
        apiWeather.getMain().getTemp_min();
        apiWeather.getSys().getSunrise();
        apiWeather.getSys().getSunset();
        return null;
    }

    public String getTheSunriseTime(String location) {
        ApiWeather apiWeather = weatherRepository.getWeather(location);
        Long sunrise = apiWeather.getSys().getSunrise();
        Date date = new java.util.Date(sunrise * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-5"));
        String formattedDate = sdf.format(date);
        return formattedDate;

    }

    public String getTheSunsetTime(String location) {
        ApiWeather apiWeather = weatherRepository.getWeather(location);
        Long sunset = apiWeather.getSys().getSunset();
        Date date = new java.util.Date(sunset * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-5"));
        String formattedDate = sdf.format(date);
        return formattedDate;

    }

    public String getTheTempInF(String location) {
        ApiWeather apiWeather = weatherRepository.getWeather(location);
        Double tempK = apiWeather.getMain().getTemp();
        Double tempF = ((9d/5 * (tempK - 273)) + 32);
        return String.format("%.2f", tempF);
    }


    public String getTheHighTempF(String location) {
        ApiWeather apiWeather = weatherRepository.getWeather(location);
        Double tempK = apiWeather.getMain().getTemp_max();
        Double tempF = ((9d/5 * (tempK - 273)) + 32);
        return String.format("%.2f", tempF);
    }

    public String getTheLowTempF(String location) {
        ApiWeather apiWeather = weatherRepository.getWeather(location);
        Double tempK = apiWeather.getMain().getTemp_min();
        Double tempF = ((9d/5 * (tempK - 273)) + 32);
        return String.format("%.2f", tempF);
    }
}
