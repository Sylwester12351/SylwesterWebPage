package Sylwester.SylwesterWebPage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
//a
@Controller
public class CalcController {
    @RequestMapping("SylwesterWebPage/Calc/CalcPlus")
    public String CalcPLUS(Model model, Integer A, Integer B,Integer wynik){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("wynik",A+B);
        return "CalcPlus";
    }
    @RequestMapping("SylwesterWebPage/Calc/CalcMinus")
    public String CalcMinus(Model model, Integer Am, Integer Bm,Integer wynik){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("wynik",Am-Bm);
        return "CalcMinus";
    }
    @RequestMapping("SylwesterWebPage/Calc/CalcMno")
    public String CalcMno(Model model, Integer Ax, Integer Bx,Integer wynik){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("wynik",Ax * Bx);
        return "CalcMno";
    }
    @RequestMapping("SylwesterWebPage/Calc/CalcDziel")
    public String CalcDziel(Model model, Integer Ad, Integer Bd,Integer wynik){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("wynik",Ad/Bd);
        return "CalcDziel";
    }
}
