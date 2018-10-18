package com.andreahowes.dive_db.logic;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiveRepository {

    List<Dive> getAllDives();

    List<Dive> getDiveByLocation(String location);

    List<Dive> getDiveByDate(LocalDate date);

    Dive getDiveById(int id);

    Dive save(Dive dive);

    Dive updateDiveById(int id, Dive dive);

    Dive delete(int id);


}
