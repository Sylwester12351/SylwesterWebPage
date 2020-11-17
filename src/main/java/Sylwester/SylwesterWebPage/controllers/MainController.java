package Sylwester.SylwesterWebPage.controllers;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import static Sylwester.SylwesterWebPage.weatherPage.ConfWeather.*;


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
    public String Weather(Model model){
        String temp = null;
        model.addAttribute("date", LocalDate.now());

        URL url = null;
        try {
            url = new URL(SERVICE + City + "," + Country + "&" + "units=" + Type + "&" + "APPID=" + ApiID);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Temp
        if (!StringUtils.isBlank(line)) {
            int startIndex = line.indexOf("{\"temp\"") + 8;
            int endIndex = line.indexOf(",\"feels_like\"");
            temp = line.substring(startIndex, endIndex);
        }
        model.addAttribute("temp", temp);
        return "WeatherApp";
    }
    @GetMapping("/Calc")
    public String Calculator(Model model){
        model.addAttribute("date", LocalDate.now());
        return "Calculator";
    }
    @GetMapping("/PassGen")
    public String PasswordGenerator(Model model){
        model.addAttribute("date", LocalDate.now());
        return "PasswordGenerator";
    }
    @RequestMapping("/PassResult")
    public String CalcPLUS(Model model, Integer Genpass,String wynikgen){
        model.addAttribute("date", LocalDate.now());
        String Pass = RandomStringUtils.randomAlphabetic(Genpass);
        model.addAttribute("wynikgen",Pass);
        return "PassResult";
    }
    @RequestMapping("/CalcPlus")
    public String CalcPLUS(Model model, Integer A, Integer B,Integer wynik){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("wynik",A+B);
        return "CalcPlus";
    }

}
