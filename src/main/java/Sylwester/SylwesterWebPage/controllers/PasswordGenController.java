package Sylwester.SylwesterWebPage.controllers;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
//b
@Controller
public class PasswordGenController {
    TextData textData = new TextData();
    @RequestMapping("SylwesterWebPage/PassGen/PassResult")
    public String passResult(Model model, Integer Genpass,String wynikgen){
        model.addAttribute("date", LocalDate.now());
        String Pass = RandomStringUtils.randomAlphabetic(Genpass);
        model.addAttribute("wynikgen",Pass);
        model.addAttribute("header",textData.getPassGenHeaderResult());
        model.addAttribute("back",textData.getBack_PL());
        model.addAttribute("foot",textData.getFooter_PL());
        return "PassResult";
    }
}
