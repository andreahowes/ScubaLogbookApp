package com.andreahowes.dive_db.data.dives;

import com.andreahowes.dive_db.logic.dive.Dive;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiveRepository {

    List<Dive> getAllDives(String user);

    List<Dive> getDiveByLocation(String location);

    List<Dive> getDiveByDate(LocalDate date);

    Dive getDiveById(int id);

    Dive save(Dive dive);

    Dive updateDiveById(int id, Dive dive);

    Dive delete(int id);


}
