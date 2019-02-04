package com.andreahowes.dive_db.presentation.web;

import com.andreahowes.dive_db.logic.weather.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HomeController {

    @Resource
    private WeatherService weatherService;

    @GetMapping({"/","/home"})
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        //model.addAttribute("date", LocalDate.now());
        //model.addAttribute("temp", weatherService.getWeatherFromLocation("playa del carmen").getTemp());
        return modelAndView;
    }


}
