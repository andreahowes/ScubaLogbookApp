package com.andreahowes.dive_db.logic;

import com.andreahowes.dive_db.logic.weather.Calculations;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculationsTest {

    private Long sunrise;
    private Long sunset;
    private Double temp;

    @Before
    public void setUp() throws Exception {
         //sunset = 1539882295;
        temp = 300.0;
    }

    @Test
    public void whenGettingTheSunriseTime_shouldReturnsSunriseTime() {
        sunrise = 1539949510L;
        String theSunriseTime = Calculations.getFormattedTime(sunrise);

        assertThat(theSunriseTime).isEqualTo("06:45");
    }

    @Test
    public void whenGettingTheTempInF_shouldReturnTheTempInF() {
        Double theTempInF = Calculations.getTheTempInF(temp);

        assertThat(theTempInF).isEqualTo(80.60);

    }

}