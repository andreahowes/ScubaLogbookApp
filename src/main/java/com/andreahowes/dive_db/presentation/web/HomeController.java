package com.andreahowes.dive_db.presentation.web;

import com.andreahowes.dive_db.logic.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.time.LocalDate;

@Controller
public class HomeController {

    @Resource
    private WeatherService weatherService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("temp", weatherService.getWeatherFromLocation("playa del carmen").getTemp());
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
