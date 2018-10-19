package com.andreahowes.dive_db.logic;

public interface WeatherRepository {
    Weather getWeather(String location);
}
