package Sylwester.SylwesterWebPage.controllers;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
//b
@Controller
public class PasswordGenController {
    @RequestMapping("/PassResult")
    public String CalcPLUS(Model model, Integer Genpass,String wynikgen){
        model.addAttribute("date", LocalDate.now());
        String Pass = RandomStringUtils.randomAlphabetic(Genpass);
        model.addAttribute("wynikgen",Pass);
        return "PassResult";
    }
}
