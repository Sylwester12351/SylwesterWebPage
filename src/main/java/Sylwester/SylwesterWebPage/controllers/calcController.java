package Sylwester.SylwesterWebPage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class calcController {
    @RequestMapping("/CalcPlus")
    public String CalcPLUS(Model model, Integer A, Integer B,Integer wynik){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("wynik",A+B);
        return "CalcPlus";
    }
}
