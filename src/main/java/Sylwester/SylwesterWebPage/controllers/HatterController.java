package Sylwester.SylwesterWebPage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HatterController {
    @GetMapping("/Hatter")
    public String weather(Model model){
        return "Hatter";
    }
}
