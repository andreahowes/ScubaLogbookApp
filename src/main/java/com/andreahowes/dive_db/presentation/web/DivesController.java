package com.andreahowes.dive_db.presentation.web;


import com.andreahowes.dive_db.logic.SecurityModule.User;
import com.andreahowes.dive_db.logic.SecurityModule.UserService;
import com.andreahowes.dive_db.logic.dive.Dive;
import com.andreahowes.dive_db.logic.dive.DivesService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class DivesController {

    @Resource
    private DivesService divesService;

    @Resource
    private UserService userService;

    @GetMapping("/dive")
    public String dive(Model model) {
        model.addAttribute("divelist", divesService.getAllDives(getUserName()));
        return "/dive";
    }


    @GetMapping("/newdiveform")
    public String diveform(Model model) {
        model.addAttribute("dive", new Dive());
        return "/newdiveform";
    }

    @PostMapping("/newdivesubit")
    public String diveSubmit(@ModelAttribute Dive dive) {
        dive.setUser(getUserName());
        divesService.save(dive);
        return "redirect:/dive";
    }

    @GetMapping("/deletedive")
    public String diveDelete(@RequestParam(name = "id") Integer id) {
        divesService.delete(id);
        return "redirect:/dive";
    }

    @GetMapping("/updatedive/{id}")
    public String goToUpdateDiveForm(@PathVariable(name = "id") Integer id, Model model) {
        Dive newDive = divesService.getDiveById(id);
        newDive.setUser(getUserName());
        model.addAttribute("dive", newDive);
        return "/updateform";
    }

    @PostMapping("/updateform/{id}")
    public String submitUpdatedDive(@PathVariable(name = "id") Integer id, @ModelAttribute Dive dive) {
        dive.setUser(getUserName());
        divesService.updateDiveById(id, dive);
        return "redirect:/dive";
    }

    private String getUserName() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        User userByEmail = userService.findUserByEmail(email);
        return userByEmail.getLastName();
    }

}
