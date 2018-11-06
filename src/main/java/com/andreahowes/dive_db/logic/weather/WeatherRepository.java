package com.andreahowes.dive_db.logic.weather;

public interface WeatherRepository {
    Weather getWeather(String location);
}
