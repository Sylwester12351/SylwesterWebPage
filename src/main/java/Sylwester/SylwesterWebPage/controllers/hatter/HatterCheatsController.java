package Sylwester.SylwesterWebPage.controllers.hatter;

import Sylwester.SylwesterWebPage.entity.Player;
import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HatterCheatsController {
    @Autowired
    private PlayerRepository playerRepository;
    /*
    Codes only for tests
     */
    @GetMapping("/KillME")
    public String hatterTest(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        player.getId();
        player.setPlayerHp(0);
        playerRepository.save(player);
        return "error";
    }
}
