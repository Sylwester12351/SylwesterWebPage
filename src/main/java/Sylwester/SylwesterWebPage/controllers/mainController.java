package Sylwester.SylwesterWebPage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class mainController {
    @RequestMapping("/")
    public String mainPage(Model model){
       model.addAttribute("date", LocalDate.now());
        return "Home";
    }

    @GetMapping("/DataTest")
    public String dataTest(Model model){
        model.addAttribute("date", LocalDate.now());
        return "DataBaseTest";
    }
    @GetMapping("/WeatherAppOnline")
    public String Weather(Model model){
        model.addAttribute("date", LocalDate.now());
        return "WeatherApp";
    }
    @GetMapping("/Calc")
    public String Calculator(Model model){
        model.addAttribute("date", LocalDate.now());
        return "Calculator";
    }


}
