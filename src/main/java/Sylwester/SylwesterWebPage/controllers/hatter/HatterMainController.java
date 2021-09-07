package Sylwester.SylwesterWebPage.controllers.hatter;

import Sylwester.SylwesterWebPage.entity.Player;
import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class HatterMainController {
    @Autowired
    private PlayerRepository playerRepository;
    /*
    Main page
     */
    @GetMapping("/Hatter")
    public String hatterPage(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        player.getId();
        LocalTime prisonTime = playerRepository.find(authentication.getName()).getPlayerTimeInPrison();
        if (prisonTime !=null) {
            if (prisonTime.isAfter(LocalTime.now())){
                return "redirect:Prison";
            }
        }
        model.addAttribute("player", new Player());
        model.addAttribute("Hatter", playerRepository.find(authentication.getName()));
        float playerhp = playerRepository.find(authentication.getName()).getPlayerHp();
        Integer exp = playerRepository.find(authentication.getName()).getPlayerExp();
        Integer lvl = playerRepository.find(authentication.getName()).getPlayerLvl();
        int lvls = lvl;
        for (int i = exp; i > 100; i = i - 100) {
             lvls++;
        }
        if (lvl != lvls){
            player.setPlayerLvl(lvls);
            player.setPlayerExp(0);
            playerRepository.save(player);
        }
        System.out.println(playerhp);
        if (playerhp <= 0) {
            player.setPlayerAlive(false);
            playerRepository.save(player);
        }
        Boolean playerIsAlive = playerRepository.find(authentication.getName()).getPlayerAlive();
        System.out.println(playerIsAlive.booleanValue());
        if (playerIsAlive){
            return "Hatter";
        }else {
            return "DeadHatter";
        }
    }

    @GetMapping("/Prison")
    public String prison(Model model, Authentication authentication){
        model.addAttribute("player", new Player());
        model.addAttribute("Prison", playerRepository.find(authentication.getName()));
        return "Prison";
    }
}
