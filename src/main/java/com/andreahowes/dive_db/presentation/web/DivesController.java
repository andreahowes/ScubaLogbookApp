package com.andreahowes.dive_db.presentation.web;


import com.andreahowes.dive_db.logic.dive.Dive;
import com.andreahowes.dive_db.logic.dive.DivesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class DivesController {

    @Resource
    private DivesService divesService;

    @GetMapping("/dive")
    public String dive(Model model) {
        model.addAttribute("divelist", divesService.getAllDives());
        return "dive";
    }

    @GetMapping("/newdiveform")
    public String diveform(Model model) {
        model.addAttribute("dive", new Dive());
        return "newdiveform";
    }

    @PostMapping("/dive")
    public String diveSubmit(@ModelAttribute Dive dive) {
        divesService.save(dive);
        return "redirect:/dive";
    }

    @GetMapping(value = "/deletedive")
    public String diveDelete(@RequestParam(name = "id") Integer id) {
        divesService.delete(id);
        return "redirect:/dive";
    }

    @GetMapping(value = "/updatedive/{id}")
    public String goToUpdateDiveForm(@PathVariable(name = "id") Integer id, Model model) {
        Dive newDive = divesService.getDiveById(id);
        model.addAttribute("dive", newDive);
        return "updateform";
    }

    @PostMapping("/updateform/{id}")
    public String submitUpdatedDive(@PathVariable(name = "id") Integer id, @ModelAttribute Dive dive) {
        divesService.updateDiveById(id, dive);
        return "redirect:/dive";
    }

}
