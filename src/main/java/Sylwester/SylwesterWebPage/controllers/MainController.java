package Sylwester.SylwesterWebPage.controllers;

import Sylwester.SylwesterWebPage.weatherPage.GetTemp;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class MainController {
    private GetTemp getTemp = new GetTemp();

    @RequestMapping("/")
    public String mainPage(Model model, Authentication authentication){
        if (authentication != null){
            model.addAttribute("userName",authentication.getName()+" "+"Zalogowany !");
        }else {
            model.addAttribute("userName","Nie jesteś zalogowany !");
        }
       model.addAttribute("date", LocalDate.now());
        return "Home";
    }

    @GetMapping("/WeatherAppOnline")
    public String weather(Model model){

        /**
         * Fix error
         */
        getTemp.setCity("Krakow"); // Ground state, so that there are no errors
        getTemp.setCountry("pl");

        getTemp.convert();
        String temp = getTemp.getTemperature();
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("temp", temp);
        model.addAttribute("cityTextG",getTemp.getCity());

        return "WeatherApp";
    }
    @RequestMapping("SylwesterWebPage/WeatherAppOnline/WeatherAppNewCity")
    public String weatherAppNewCity(Model model, String Country, String City){
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
    public String errorPage(Model model){
        return "error";
    }

    @GetMapping("/favicon.ico")
    public String jokePage(Model model){return "IconEgg";}
}
