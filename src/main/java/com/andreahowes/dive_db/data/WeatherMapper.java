package com.andreahowes.dive_db.data;

import com.andreahowes.dive_db.logic.weather.Calculations;
import com.andreahowes.dive_db.logic.weather.Weather;
import org.springframework.stereotype.Service;

@Service
public class WeatherMapper {


    public static Weather mapWeather(ApiWeather apiWeather) {

        Weather weather = new Weather();

        Long sunrise = apiWeather.getSys().getSunrise();
        weather.setSunrise(Calculations.getFormattedTime(sunrise));


        Long sunset = apiWeather.getSys().getSunset();
        weather.setSunset(Calculations.getFormattedTime(sunset));


        Double temp = apiWeather.getMain().getTemp();
        weather.setTemp(Calculations.getTheTempInF(temp));


        Double maxTemp = apiWeather.getMain().getTemp_max();
        weather.setMaxTemp(Calculations.getTheTempInF(maxTemp));


        Double minTemp = apiWeather.getMain().getTemp_min();
        weather.setMinTemp(Calculations.getTheTempInF(minTemp));

        return weather;

    }


}
