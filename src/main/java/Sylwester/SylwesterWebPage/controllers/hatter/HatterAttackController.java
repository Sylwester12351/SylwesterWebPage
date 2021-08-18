package Sylwester.SylwesterWebPage.controllers.hatter;

import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class HatterAttackController {
    @Autowired
    private PlayerRepository playerRepository;

    Random random = new Random();

    @GetMapping("/AttackHatter")
    public String attackHatter(Model model, Authentication authentication){

        return "AttackHatter";
    }
}
