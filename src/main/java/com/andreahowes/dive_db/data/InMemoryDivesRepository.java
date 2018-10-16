package com.andreahowes.dive_db.data;

import com.andreahowes.dive_db.logic.Dive;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryDivesRepository implements DiveRepository {

    private List<Dive> diveList;

    public InMemoryDivesRepository() {
        this.diveList = new ArrayList<>();
    }

    @Override
    public List<Dive> getAllDives() {
        return diveList;
    }

    @Override
    public Dive getDiveByLocation(String location) {
        return getByLocation(location);
    }

    @Override
    public Dive getDiveByDate(LocalDate date) {
        return getByDate(date);

    }

    @Override
    public Dive save(Dive dive) {
        diveList.add(dive);
        return diveList.get(diveList.indexOf(dive));
    }

    @Override
    public Dive updateDiveById(int id, Dive dive) {
        Dive dive1 = getById(id);
        int i = diveList.indexOf(dive1);
        diveList.remove(i);
        diveList.add(i, dive);
        return diveList.get(i);
    }


    @Override
    public Dive delete(int id) {
        Dive dive = getById(id);
        diveList.remove(dive);
        return dive;
    }

    private Dive getById(int id) {
        for (Dive diveInList : diveList) {
            if (diveInList.getId() == id) {
                return diveInList;
            }
        }
        return null;
    }

    private Dive getByLocation(String location) {
        for (Dive diveInList : diveList) {
            if (diveInList.getLocation().equals(location)) {
                return diveInList;
            }
        }
        return null;
    }

    private Dive getByDate(LocalDate date) {
        for (Dive diveInList : diveList) {
            if (diveInList.getDate().isEqual(date)) {
                return diveInList;
            }
        }
        return null;
    }
}
