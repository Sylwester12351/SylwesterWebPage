package Sylwester.SylwesterWebPage.controllers.hatter;

import Sylwester.SylwesterWebPage.entity.Economy;
import Sylwester.SylwesterWebPage.repository.EconomyRepository;
import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;
import java.util.Random;

@Controller
public class HatterSellController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private EconomyRepository economyRepository;

    Random random = new Random();

    @GetMapping("/SellHatter")
    public String sellHatter(Model model, Authentication authentication){
        LocalTime localTime = LocalTime.now();
        Boolean playerIsAlive = playerRepository.find(authentication.getName()).getPlayerAlive();
        LocalTime prisonTime = playerRepository.find(authentication.getName()).getPlayerTimeInPrison();
        model.addAttribute("eco", new Economy());
        model.addAttribute("COST", economyRepository.findAll());
        if (prisonTime !=null) {
            if (prisonTime.isAfter(LocalTime.now())){
                return "redirect:Prison";
            }
        }
        System.out.println(playerIsAlive.booleanValue());
        if (playerIsAlive){
            return "SellHatter";
        }else {
            return "DeadHatter";
        }
    }
//    TODO
    @RequestMapping("/SellHatterAMF")
    public String sellHatterAMF(Model model, Authentication authentication, Integer Amphet){
        return "error";
    }
    @RequestMapping("/SellHatterTHC")
    public String sellHatterTHC(Model model, Authentication authentication, Integer THC){
        return "error";
    }
    @RequestMapping("/SellHatterCOC")
    public String sellHatterCOC(Model model, Authentication authentication, Integer COC){
        return "error";
    }
}
