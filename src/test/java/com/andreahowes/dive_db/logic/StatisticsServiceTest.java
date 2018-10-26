package com.andreahowes.dive_db.logic;

import com.andreahowes.dive_db.logic.dive.Dive;
import com.andreahowes.dive_db.logic.dive.DivesService;
import com.andreahowes.dive_db.logic.dive.StatisticsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class StatisticsServiceTest {
    private List<Dive> diveList = new ArrayList<>();
    private StatisticsService statisticsService;
    private DivesService divesServiceMock;

    @Before
    public void setUp() throws Exception {
        Dive dive1 = new Dive();
        Dive dive2 = new Dive();
        dive1.setDurationInMinutes(60);
        dive2.setDurationInMinutes(40);
        dive1.setMaxDepthInMeters(18);
        dive2.setMaxDepthInMeters(30);
        diveList.add(dive1);
        diveList.add(dive2);
        divesServiceMock = Mockito.mock(DivesService.class);
        statisticsService = new StatisticsService(divesServiceMock);
    }

    @Test
    public void whenGettingTotalNumberOfDives_shouldReturnTotalNumberOfDives() {
        when(divesServiceMock.getAllDives()).thenReturn(diveList);

        double totalNumberOfDives = statisticsService.getTotalNumberOfDives();

        assertThat(totalNumberOfDives).isEqualTo(2);
    }

    @Test
    public void whenGettingTotalTimeInWater_shouldReturnTotalTimeInWaterInMinutes() {
        when(divesServiceMock.getAllDives()).thenReturn(diveList);

        double totalTimeInWaterInMinutes = statisticsService.getTotalTimeInWaterInMinutes();

        assertThat(totalTimeInWaterInMinutes).isEqualTo(100);
    }

    @Test
    public void whenGettingMaxDepth_shouldReturnMaxDepthInMeters() {
        when(divesServiceMock.getAllDives()).thenReturn(diveList);

        double maxDepthInMetersForAllDives = statisticsService.getMaxDepthInMetersForAllDives();

        assertThat(maxDepthInMetersForAllDives).isEqualTo(30);
    }


    @Test
    public void whenGettingMinDepth_shouldReturnMinDepthInMeters() {
        when(divesServiceMock.getAllDives()).thenReturn(diveList);

        double minDepthInMetersForAllDives = statisticsService.getMinDepthInMetersForAllDives();

        assertThat(minDepthInMetersForAllDives).isEqualTo(18);
    }


    @Test
    public void whenGettingAverageDepthInMetersForAllDives_shouldReturnAverageDepthInMeters() {
        when(divesServiceMock.getAllDives()).thenReturn(diveList);

        double averageDepthInMetersForAllDives = statisticsService.getAverageDepthInMetersForAllDives();

        assertThat(averageDepthInMetersForAllDives).isEqualTo(24);
    }

}