package Sylwester.SylwesterWebPage.controllers;

import Sylwester.SylwesterWebPage.weatherPage.ConfWeather;
import Sylwester.SylwesterWebPage.weatherPage.GetTemp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;

@Controller
public class MainController {
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
    public String weather(Model model){
        GetTemp getTemp = new GetTemp();
        getTemp.convert();
        String temp = getTemp.getTemperature();
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("temp", temp);
        return "WeatherApp";
    }
    @RequestMapping("/WeatherAppNewCity")
    public String weatherAppNewCity(Model model, String Country, String City){
        GetTemp getTemp = new GetTemp();
        getTemp.setCountry(Country);
        getTemp.setCity(City);
        getTemp.convert();
        String Temperature = getTemp.getTemperature();
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("temp",Temperature);
        model.addAttribute("countryText",getTemp.getCountry());
        model.addAttribute("cityText",getTemp.getCity());
        return "WeatherAppNewCity";
    }
    @GetMapping("/Calc")
    public String calculator(Model model){
        model.addAttribute("date", LocalDate.now());
        return "Calculator";
    }
    @GetMapping("/PassGen")
    public String passwordGenerator(Model model){
        model.addAttribute("date", LocalDate.now());
        return "PasswordGenerator";
    }
    @GetMapping("/error")
    public String errorPage(){
        return "error";
    }


}
