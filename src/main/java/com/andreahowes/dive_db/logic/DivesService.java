package com.andreahowes.dive_db.logic;

import com.andreahowes.dive_db.data.DiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Dive> getAllDives(){
        return diveRepository.getAllDives();
    }
    public Dive getDiveByLocation(String location) {
        return diveRepository.getDiveByLocation(location);
    }

    public Dive getDiveByDate(LocalDate date) {
        return diveRepository.getDiveByDate(date);
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