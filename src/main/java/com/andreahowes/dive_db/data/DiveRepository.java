package com.andreahowes.dive_db.data;

import com.andreahowes.dive_db.logic.Dive;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiveRepository {

    List<Dive> getAllDives();

    Dive getDiveByLocation(String location);

    Dive getDiveByDate(LocalDate date);

    Dive save(Dive dive);

    Dive updateDiveById(int id, Dive dive);

    Dive delete(int id);


}
