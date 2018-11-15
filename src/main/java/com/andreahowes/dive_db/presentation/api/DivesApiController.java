package com.andreahowes.dive_db.presentation.api;

import com.andreahowes.dive_db.logic.SecurityModule.JWT.MyTokenService;
import com.andreahowes.dive_db.logic.dive.Dive;
import com.andreahowes.dive_db.logic.dive.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user/logbook/dives")
public class DivesApiController {

    private DivesService divesService;

    private MyTokenService myTokenService;

    @Autowired
    public DivesApiController(DivesService divesService, MyTokenService myTokenService) {
        this.divesService = divesService;
        this.myTokenService = myTokenService;
    }

    @GetMapping("/{user}")
    public List<Dive> getAllDives(@PathVariable String user, @RequestParam(name = "token") String tokenValue) {
        myTokenService.validateTokenByValue(tokenValue);
        return divesService.getAllDives(user);
    }

    @GetMapping("/location/{location}")
    public List<Dive> getDiveByLocation(@RequestParam(name = "token") String tokenValue, @PathVariable String location) {
        myTokenService.validateTokenByValue(tokenValue);
        return divesService.getDiveByLocation(location);
    }

    @GetMapping("/date/{date}")
    public List<Dive> getDiveByDate(@RequestParam(name = "token") String tokenValue, @PathVariable String date) {
        myTokenService.validateTokenByValue(tokenValue);
        return divesService.getDiveByDate(LocalDate.parse(date));
    }

    @GetMapping("/id/{id}")
    public Dive getDiveById(@RequestParam(name = "token") String tokenValue, @PathVariable Integer id) {
        myTokenService.validateTokenByValue(tokenValue);
        return divesService.getDiveById(id);
    }

    @PutMapping("/{id}")
    public Dive updateDiveById(@RequestParam(name = "token") String tokenValue, @PathVariable int id, @RequestBody Dive dive) {
        myTokenService.validateTokenByValue(tokenValue);
        return divesService.updateDiveById(id, dive);
    }

    @DeleteMapping("/{id}")
    public Dive deleteDive(@RequestParam(name = "token") String tokenValue, @PathVariable int id) {
        myTokenService.validateTokenByValue(tokenValue);
        return divesService.delete(id);
    }

}
