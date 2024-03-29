package Sylwester.SylwesterWebPage.controllers;

import Sylwester.SylwesterWebPage.entity.AdditionalText;
import Sylwester.SylwesterWebPage.entity.NewsDataBase;
import Sylwester.SylwesterWebPage.news.GetNews;
import Sylwester.SylwesterWebPage.repository.AdditionalTextRepository;
import Sylwester.SylwesterWebPage.repository.NewsRepository;
import Sylwester.SylwesterWebPage.weatherPage.GetTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class MainController {
    private GetTemp getTemp = new GetTemp();

    @Autowired
    private NewsRepository newsRepository;

    private NewsDataBase newsDataBase = new NewsDataBase();

    @Autowired
    private AdditionalTextRepository additionalTextRepository;

    @RequestMapping("/")
    public String choicePage(Model model){
        return "Choice";
    }

    @RequestMapping("/default")
    public String defaultPage(Model model, Authentication authentication){
        GetNews getNews = new GetNews();
        getNews.convert();
        getTemp.setCity("Krakow"); // Ground state, so that there are no errors
        getTemp.setCountry("pl");
        getTemp.convert();
        String temp = getTemp.getTemperature();
        if (authentication != null){
            model.addAttribute("userName",authentication.getName()+" "+"Zalogowany !");
        }else {
            model.addAttribute("userName","Nie jesteś zalogowany !");
        }
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("info", new AdditionalText());
        model.addAttribute("message", additionalTextRepository.findAll());
        model.addAttribute("temp", temp);
        model.addAttribute("name",getNews.getList());

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
    @GetMapping("/404")
    public String pageNotFound(Model model){
        return "404err";
    }

    @GetMapping("/LogoutSucces")
    public String logout(Model model){
        return "LogoutSucces";
    }

    @GetMapping("/favicon.ico")
    public String jokePage(Model model){return "IconEgg";}

    @GetMapping("/ForumHome")
    public String ForumHomePage(Model model){return "UncensoredForumHome";}
}
