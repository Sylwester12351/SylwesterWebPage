package Sylwester.SylwesterWebPage.controllers;


import Sylwester.SylwesterWebPage.entity.Player;
import Sylwester.SylwesterWebPage.entity.User;
import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import Sylwester.SylwesterWebPage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    UserRepository userRepo;
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Player player = new Player();
        player.setPlayerAlive(true);
        player.setPlayerInPrison(false);
        player.setPlayerHp(100);
        player.setPlayerMoney(450);
        player.setPlayerLvl(1);
        player.setPlayerAimHead(30);
        player.setPlayerAimBody(70);
        player.setPlayerTestMode(false);
        player.setPlayerNick(user.getNick());
        playerRepository.save(player);
        userRepo.save(user);

        return "Succes";
    }

}
