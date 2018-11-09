package com.andreahowes.dive_db.logic.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DivesService {
    private DiveRepository diveRepository;

    @Autowired
    public DivesService(DiveRepository diveRepository) {
        this.diveRepository = diveRepository;
    }

    @Cacheable("allDives")
    public List<Dive> getAllDives() {
        return diveRepository.getAllDives();
    }

    public List<Dive> getDiveByLocation(String location) {
        return diveRepository.getDiveByLocation(location);
    }

    public List<Dive> getDiveByDate(LocalDate date) {
        return diveRepository.getDiveByDate(date);
    }

    public Dive getDiveById(int id) {
        return diveRepository.getDiveById(id);
    }

    public Dive save(Dive dive) {
        return diveRepository.save(dive);
    }

    public Dive updateDiveById(int id, Dive dive) {
        return diveRepository.updateDiveById(id, dive);
    }

    public Dive delete(int id) {
        return diveRepository.delete(id);
    }

}