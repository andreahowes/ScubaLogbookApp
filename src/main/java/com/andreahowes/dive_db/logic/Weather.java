package com.andreahowes.dive_db.logic;

public class Weather {
    private String sunrise;
    private String sunset;
    private Double temp;
    private Double maxTemp;
    private Double minTemp;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    //  @Autowired
  //  public Weather(WeatherMapper weatherMapper){
  //      this.weatherMapper = weatherMapper;
//
  //  }
//
  //  public Weather() {
  //  }
//
  //  public Weather getWeatherFromLocation(String location) {
  //      return weatherMapper.getWeather(location);
//
//
  //   private
  //  }
}
