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
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HatterAttackController {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerRaportRepository playerRaportRepository;

    Random random = new Random(10);

    @GetMapping("/AttackHatter")
    public String attackHatter(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        LocalTime localTime = LocalTime.now();
        Boolean playerIsAlive = player.getPlayerAlive();
        LocalTime prisonTime = player.getPlayerTimeInPrison();
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
        float damage = 0;
        float allDamage = 0;
        PlayerRaport playerRaport = new PlayerRaport();
        List<PlayerRaport> playerRaportList = new ArrayList<>();
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
            float attackerDAMAGE = attackerPlayer.getPlayerDamage();
            Boolean attackerAlive = attackerPlayer.getPlayerAlive();

            if (attackedLEVEL < 10 || attackerLEVEL < 10 || attackerBullet < Bullet || !attackerAlive || !attackedAlive ){
                return "error";
            }else {
                int lastbullets = attackerBullet - Bullet;
                while (true){
                    Bullet = Bullet - 1;
                    if (Bullet == 0){
                        break;
                    }else {
                        damage = random.nextFloat() + attackerDAMAGE; // DAMAGE
                        allDamage = allDamage + damage;
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
                attackedPlayer.setPlayerKiller(attackerPlayer.getPlayerNick());
                attackedPlayer.setPlayerLastAttacker("Przeprowadził gracz :"+attackerPlayer.getPlayerNick());

                playerRaport.setPlayerMessage("Zaatakowałeś skutecznie gracza: " + attackedPlayer.getPlayerNick() + " Zadałeś obrażenia: " + allDamage
                        + " Pozostało życia: " + attackedHP + " Pozostało pancerza: " + attackedARMOR + " Koniec raportu");
                playerRaportList.add(playerRaport);
                attackerPlayer.setPlayerRaports(playerRaportList);


                attackerPlayer.setPlayerBullet(lastbullets);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(attackedPlayer);
                playerRepository.save(attackerPlayer);
                return "redirect:Hatter";
            }
        }
    }
}
