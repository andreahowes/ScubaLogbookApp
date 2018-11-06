package com.andreahowes.dive_db.presentation.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value="name", defaultValue="misterious guy") String name){
        return "Welcome " + name;
    }
}