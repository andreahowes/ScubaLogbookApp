package com.andreahowes.dive_db.presentation;

import com.andreahowes.dive_db.logic.Dive;
import com.andreahowes.dive_db.logic.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user/logbook/dives")
public class DivesController {

    @Resource
    private DivesService divesService;

    @Autowired
    public DivesController(DivesService divesService) {
        this.divesService = divesService;
    }

    @GetMapping
    public List<Dive> getAllDives() {
        return divesService.getAllDives();
    }

    @GetMapping("/location/{location}")
    public Dive getDiveByLocation(@PathVariable String location) {
        return divesService.getDiveByLocation(location);
    }

    @GetMapping("/date/{date}")
    public Dive getDiveByDate(@PathVariable String date) {
        return divesService.getDiveByDate(LocalDate.parse(date));
    }

    @PostMapping
    public Dive save(@RequestBody Dive dive) {
        return divesService.save(dive);
    }

    @PutMapping("/{id}")
    public Dive updateDiveById(@PathVariable int id, @RequestBody Dive dive) {
        return divesService.updateDiveById(id, dive);
    }

    @DeleteMapping("/{id}")
    public Dive deleteDive(@PathVariable int id) {
        return divesService.delete(id);
    }

}
