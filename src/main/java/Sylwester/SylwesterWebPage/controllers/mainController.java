package Sylwester.SylwesterWebPage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/")
    public String mainPage(){return "Home";}
    @GetMapping("/DataTest")
    public String dataTest(){return "DataBaseTest";}
    @GetMapping("/WeatherAppOnline")
    public String Weather(){return "WeatherApp";}


}
