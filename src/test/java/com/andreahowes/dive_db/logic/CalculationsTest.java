package com.andreahowes.dive_db.logic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculationsTest {

    private Integer sunrise;
    private Long sunset;
    private Double temp;

    @Before
    public void setUp() throws Exception {
         //sunset = 1539882295;
        temp = 300.0;
    }

    @Test
    public void whenGettingTheSunriseTime_shouldReturnsSunriseTime() {
        sunrise = 1539842822;
        Long sunriseL = Long.valueOf(sunrise);
        String theSunriseTime = Calculations.getTheSunriseTime(sunriseL);

        assertThat(theSunriseTime).isEqualTo("6:45");
    }

    @Test
    public void whenGettingTheSunsetTime_shouldReturnsSunsetTime() {
    }

    @Test
    public void whenGettingTheTempInF_shouldReturnTheTempInF() {
        String theTempInF = Calculations.getTheTempInF(temp);

        assertThat(theTempInF).isEqualTo(80.60);

    }

}