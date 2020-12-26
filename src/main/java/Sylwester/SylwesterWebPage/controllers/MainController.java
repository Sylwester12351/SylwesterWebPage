package Sylwester.SylwesterWebPage.controllers;

import Sylwester.SylwesterWebPage.weatherPage.GetTemp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Sylwester.SylwesterWebPage.controllers.TextData;
import java.time.LocalDate;

@Controller
public class MainController {
    private GetTemp getTemp = new GetTemp();
    private TextData textData = new TextData();

    @RequestMapping("/")
    public String mainPage(Model model){
       model.addAttribute("date", LocalDate.now());
       model.addAttribute("head",textData.getHomeHeader_PL());
       model.addAttribute("blog",textData.getHomeMenuBlog_PL());
       model.addAttribute("regist",textData.getHomeMenuRegister_PL());
       model.addAttribute("weather",textData.getHomeMenuWeather_PL());
       model.addAttribute("calc",textData.getHomeMenuCalc_PL());
       model.addAttribute("pass",textData.getHomeMenuPass_PL());
       model.addAttribute("profiles",textData.getHomeProfiles_PL());
       model.addAttribute("email",textData.getHomeMyEmailAddres_PL());
       model.addAttribute("content",textData.getHomeContent_PL());
       model.addAttribute("foot",textData.getFooter_PL());
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

        model.addAttribute("titleW",textData.getWeatherTitle_PL());
        model.addAttribute("head",textData.getWeatherHeader_PL());
        model.addAttribute("back",textData.getBack_PL());
        model.addAttribute("info",textData.getWeatherInformation_PL());
        model.addAttribute("countryText",textData.getWeatherCountry_PL());
        model.addAttribute("cityText",textData.getWeatherCity_PL());
        model.addAttribute("celc",textData.getWeatherContent_PL());
        model.addAttribute("foot",textData.getFooter_PL());
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
        model.addAttribute("header",textData.getNewWeatherHeader_PL());
        model.addAttribute("foot",textData.getFooter_PL());
        model.addAttribute("back",textData.getBack_PL());
        return "WeatherAppNewCity";
    }
    @GetMapping("/Calc")
    public String calculator(Model model){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("header",textData.getCalcHeader_PL());
        model.addAttribute("back",textData.getBack_PL());
        model.addAttribute("content",textData.getCalcContent_PL());
        model.addAttribute("contentDT",textData.getCalcContentDT_PL());
        model.addAttribute("foot",textData.getFooter_PL());
        return "Calculator";
    }
    @GetMapping("/PassGen")
    public String passwordGenerator(Model model){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("header",textData.getPassGenHeader());
        model.addAttribute("back",textData.getBack_PL());
        model.addAttribute("contentL",textData.getPassGenContentL());
        model.addAttribute("foot",textData.getFooter_PL());
        return "PasswordGenerator";
    }
    @GetMapping("/error")
    public String errorPage(Model model){
        return "error";
    }

    @GetMapping("/register")
    public String registerPage(Model model){return "register";}

    @GetMapping("/TESTER")
    public String testPage(Model model){return "TESTER";}
}
