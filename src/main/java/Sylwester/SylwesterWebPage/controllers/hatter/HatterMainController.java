package Sylwester.SylwesterWebPage.controllers.hatter;

import Sylwester.SylwesterWebPage.entity.Player;
import Sylwester.SylwesterWebPage.entity.PlayerRaport;
import Sylwester.SylwesterWebPage.repository.PlayerRaportRepository;
import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * todo dodać płatność dośwadczeniem za podbicie statystyk celowania i DMG
 */
@Controller
public class HatterMainController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerRaportRepository playerRaportRepository;
    /*
    Main page
     */
    @GetMapping("/Hatter")
    public String hatterPage(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        player.getId();
        LocalTime prisonTime = player.getPlayerTimeInPrison();
        if (prisonTime !=null) {
            if (prisonTime.isAfter(LocalTime.now())){
                return "redirect:Prison";
            }
        }
        model.addAttribute("player", new Player());
        model.addAttribute("Hatter", playerRepository.find(authentication.getName()));
        float playerhp = player.getPlayerHp();
        Integer exp = player.getPlayerExp();
        Integer lvl = player.getPlayerLvl();
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
        Boolean playerIsAlive = player.getPlayerAlive();
        System.out.println(playerIsAlive.booleanValue());
        if (playerIsAlive){
            return "Hatter";
        }else {
            return "DeadHatter";
        }
    }

    @GetMapping("/DeadHatter")
    public String playerIsDead(Model model, Authentication authentication){
        model.addAttribute("player", new Player());
        model.addAttribute("Hatter", playerRepository.find(authentication.getName()));
        return "DeadHatter";
    }

    @GetMapping("/Prison")
    public String prison(Model model, Authentication authentication){
        model.addAttribute("player", new Player());
        model.addAttribute("Prison", playerRepository.find(authentication.getName()));
        return "Prison";
    }
    @GetMapping("/Raport")
    public String raport(Model model, Authentication authentication){
        model.addAttribute("playerRaport", new Player());
        model.addAttribute("raport", playerRepository.find(authentication.getName()));
        return "RaportHatter";
    }

    /**
     * todo dodac gre lotto
     * todo dodac szpiega
     */
    @GetMapping("/Lotto")
    public String lotto(Model model, Authentication authentication){
//        model.addAttribute("playerRaport", new Player());
//        model.addAttribute("raport", playerRepository.find(authentication.getName()));
        return "LottoHatter";
    }
    @GetMapping("/Spy")
    public String spy(Model model, Authentication authentication){
//        model.addAttribute("playerRaport", new Player());
//        model.addAttribute("raport", playerRepository.find(authentication.getName()));
        return "SpyHatter";
    }
}
