package com.andreahowes.dive_db.logic;

import com.andreahowes.dive_db.data.ApiWeather;

public interface WeatherRepository {
    ApiWeather getWeather(String location);
}
