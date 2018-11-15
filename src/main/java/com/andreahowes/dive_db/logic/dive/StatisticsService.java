package com.andreahowes.dive_db.logic.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StatisticsService {

    private DivesService divesService;

    @Autowired
    public StatisticsService(DivesService divesService) {
        this.divesService = divesService;
    }

    public double getTotalNumberOfDives(String user) {
        return divesService.getAllDives(user).size();
    }

    public double getTotalTimeInWaterInMinutes(String user) {
        List<Dive> allDives = divesService.getAllDives(user);
        double totalTimeInWater = 0;
        for (Dive dive : allDives) {
            totalTimeInWater += dive.getDurationInMinutes();
        }
        return totalTimeInWater;

    }

    public double getMaxDepthInMetersForAllDives(String user) {
        return divesService.getAllDives(user)
                .stream()
                .max(Comparator.comparing(Dive::getMaxDepthInMeters))
                .get()
                .getMaxDepthInMeters();


//
//        List<Dive> allDives = divesService.getAllDives();
//
//        double maxDepth = 0;
//        for (Dive dive : allDives) {
//            if (maxDepth < dive.getMaxDepthInMeters()) {
//                maxDepth = dive.getMaxDepthInMeters();
//            }
//        }
//        return maxDepth;
    }

    public double getMinDepthInMetersForAllDives(String user) {
        List<Dive> allDives = divesService.getAllDives(user);

        Dive dive1 = allDives.get(0);
        double minDepth = dive1.getMaxDepthInMeters();
        for (Dive dive : allDives) {
            if (minDepth > dive.getMaxDepthInMeters()) {
                minDepth = dive.getMaxDepthInMeters();
            }
        }
        return minDepth;
    }

    public double getAverageDepthInMetersForAllDives(String user) {
        List<Dive> allDives = divesService.getAllDives(user);

        double sumOfAllDepths = 0;
        for (Dive dive : allDives) {
            sumOfAllDepths += dive.getMaxDepthInMeters();
        }
        double numberOfDives = getTotalNumberOfDives(user);
        return sumOfAllDepths / numberOfDives;
    }

}
