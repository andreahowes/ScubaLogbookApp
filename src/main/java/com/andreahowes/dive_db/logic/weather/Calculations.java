package com.andreahowes.dive_db.logic.weather;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculations {


    public static String getFormattedTime(Long sunrise) {
        Date date = new java.util.Date(sunrise * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-5"));
        String formattedDate = sdf.format(date);
        return formattedDate;

    }

    public static Double getTheTempInF(Double temp) {
        Double tempF = ((9d / 5 * (temp - 273)) + 32);
        String format = String.format("%.2f", tempF);
        return Double.valueOf(format);
    }

}
