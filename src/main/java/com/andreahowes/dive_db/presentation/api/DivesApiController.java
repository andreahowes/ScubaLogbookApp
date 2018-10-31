package com.andreahowes.dive_db.presentation.api;

import com.andreahowes.dive_db.logic.SecurityModule.JWT.MyTokenService;
import com.andreahowes.dive_db.logic.dive.Dive;
import com.andreahowes.dive_db.logic.dive.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user/logbook/dives")
public class DivesApiController {

    @Autowired
    private DivesService divesService;

    @Resource
    public MyTokenService tokenService;

    @Autowired
    public DivesApiController(DivesService divesService) {
        this.divesService = divesService;
    }

    @GetMapping()
    public List<Dive> getAllDives(@RequestParam(name = "token") String tokenValue) {

        tokenService.validateTokenByValue(tokenValue);

        return divesService.getAllDives();

    }

    @GetMapping("/location/{location}")
    public List<Dive> getDiveByLocation(@RequestParam(name = "token") String tokenValue, @PathVariable String location) {
        tokenService.validateTokenByValue(tokenValue);
        return divesService.getDiveByLocation(location);
    }

    @GetMapping("/date/{date}")
    public List<Dive> getDiveByDate(@RequestParam(name = "token") String tokenValue, @PathVariable String date) {
        tokenService.validateTokenByValue(tokenValue);
        return divesService.getDiveByDate(LocalDate.parse(date));
    }

    @GetMapping("/id/{id}")
    public Dive getDiveById(@RequestParam(name = "token") String tokenValue, @PathVariable Integer id) {
        tokenService.validateTokenByValue(tokenValue);

        return divesService.getDiveById(id);
    }


    @PutMapping("/{id}")
    public Dive updateDiveById(@RequestParam(name = "token") String tokenValue, @PathVariable int id, @RequestBody Dive dive) {
        tokenService.validateTokenByValue(tokenValue);

        return divesService.updateDiveById(id, dive);
    }

    @DeleteMapping("/{id}")
    public Dive deleteDive(@RequestParam(name = "token") String tokenValue, @PathVariable int id) {
        tokenService.validateTokenByValue(tokenValue);

        return divesService.delete(id);
    }

}
