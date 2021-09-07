package Sylwester.SylwesterWebPage.controllers.hatter;


import Sylwester.SylwesterWebPage.entity.Player;
import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalTime;
import java.util.Random;

@Controller
public class HatterAttackController {
    @Autowired
    private PlayerRepository playerRepository;

    Random random = new Random(10);

    @GetMapping("/AttackHatter")
    public String attackHatter(Model model, Authentication authentication){
        LocalTime localTime = LocalTime.now();
        Boolean playerIsAlive = playerRepository.find(authentication.getName()).getPlayerAlive();
        LocalTime prisonTime = playerRepository.find(authentication.getName()).getPlayerTimeInPrison();
        if (prisonTime !=null) {
            if (prisonTime.isAfter(LocalTime.now())){
                return "redirect:Prison";
            }
        }
        if (!playerIsAlive){
            return "DeadHatter";
        }
        model.addAttribute("Player", new Player());
        model.addAttribute("Players",playerRepository.findAll());
        return "AttackHatter";
    }

    @PostMapping("/AttackHatterATTACK")
    public String attack(Model model, Authentication authentication, Integer Bullet, Integer idPlayer) {
        System.out.println(Bullet+" "+idPlayer);
        if (Bullet == null || idPlayer == null){
            return "error";
        }else {

            Player attackerPlayer = playerRepository.find(authentication.getName());
            Player attackedPlayer = playerRepository.findAllById(idPlayer.longValue());

            float attackedHP = attackedPlayer.getPlayerHp();
            float attackedARMOR = attackedPlayer.getPlayerArmor();
            int attackedLEVEL = attackedPlayer.getPlayerLvl();
            Boolean attackedAlive = attackedPlayer.getPlayerAlive();
           // int done = attackedHP - Bullet;

            int attackerBullet = attackerPlayer.getPlayerBullet();
            int attackerLEVEL = attackerPlayer.getPlayerLvl();
            Boolean attackerAlive = attackerPlayer.getPlayerAlive();

            if (attackedLEVEL < 3 || attackerLEVEL < 3 || attackerBullet < Bullet || !attackerAlive || !attackedAlive ){
                return "error";
            }else {
                int lastbullets = attackerBullet - Bullet;
                while (true){
                    Bullet = Bullet - 1;
                    if (Bullet == 0){
                        break;
                    }else {
                        float damage = random.nextFloat() + 0.4f; // DAMAGE
                        if (attackedARMOR > 0){
                            attackedARMOR = attackedARMOR - damage;
                        }else {
                                attackedHP = attackedHP - damage;
                                if (attackedHP < 0){
                                    break;
                            }
                        }
                    }
                }
                attackedPlayer.setPlayerHp(attackedHP);
                attackedPlayer.setPlayerArmor(attackedARMOR);

                attackerPlayer.setPlayerBullet(lastbullets);
                playerRepository.save(attackedPlayer);
                playerRepository.save(attackerPlayer);
                return "error";
            }
        }
    }
}
