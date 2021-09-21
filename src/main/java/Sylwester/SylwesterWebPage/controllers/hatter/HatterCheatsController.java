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

import java.util.ArrayList;
import java.util.List;

@Controller
public class HatterCheatsController {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerRaportRepository playerRaportRepository;
    /*
    Codes only for tests
     */
    @GetMapping("/kill")
    public String kill(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        boolean testmode = player.isPlayerTestMode();
        if (testmode){
            player.setPlayerHp(0);
            playerRepository.save(player);
            return "CheatActive";
        }
        return "error";
    }
    @GetMapping("/esc")
    public String prisonEscape(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        boolean testmode = player.isPlayerTestMode();
        if (testmode){
            player.setPlayerTimeInPrison(null);
            playerRepository.save(player);
            return "CheatActive";
        }
        return "error";
    }
    @GetMapping("/godmode")
    public String alive(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        boolean testmode = player.isPlayerTestMode();
        if (testmode){
            player.setPlayerHp(100);
            player.setPlayerAlive(true);
            player.setPlayerArmor(100);
            playerRepository.save(player);
            return "CheatActive";
        }
        return "error";
    }
    @GetMapping("/gmod")
    public String hatterTest(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        boolean testmode = player.isPlayerTestMode();
        if (testmode){
            player.setPlayerMoney(5000);
            player.setPlayerPractice(5000);
            player.setPlayerAmphetamine(100);
            player.setPlayerCocaine(100);
            player.setPlayerMarijuana(100);
            player.setPlayerBullet(100);
            player.setPlayerArmor(100);
            player.setPlayerLvl(30);
            playerRepository.save(player);
            return "CheatActive";
        }
        return "error";
    }
    @GetMapping("/rapmod")
    public String raportTest(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        boolean testmode = player.isPlayerTestMode();
        if (testmode){
            PlayerRaport playerRaport = new PlayerRaport();
            List<PlayerRaport> playerRaportList = new ArrayList<>();
            playerRaport.setPlayerMessage("Bla bla bla bla sratatatata");
            playerRaportList.add(playerRaport);
            player.setPlayerRaports(playerRaportList);
            playerRaportRepository.save(playerRaport);
            playerRepository.save(player);
            return "CheatActive";
        }
        return "error";
    }
}
