package Sylwester.SylwesterWebPage.controllers.hatter;

import Sylwester.SylwesterWebPage.entity.Economy;
import Sylwester.SylwesterWebPage.entity.Player;
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

    @RequestMapping("/SellHatterAMF")
    public String sellHatterAMF(Model model, Authentication authentication, Integer Amphet) {
        Player player = playerRepository.find(authentication.getName());
        int cost = economyRepository.findById(1L).get().getPriceAmphetamine();
        player.getId();
        Integer money = playerRepository.find(authentication.getName()).getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(60);
        int price = cost * Amphet;
        int plus = money + price;
        int exp = playerRepository.find(authentication.getName()).getPlayerExp();
        int addExp = exp + Amphet * 30;
        int AmphetPlayer = playerRepository.find(authentication.getName()).getPlayerAmphetamine();
        int deleteAmphet = AmphetPlayer - Amphet;
        if (AmphetPlayer <= 0) {
            return "FailedBuy";
        } else {
            if (rnd <= 28) { // jeżeli ma trafić do więzienia  28%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRepository.save(player);
                return "redirect:Prison";
            } else { // jeżeli się powiodło
                player.setPlayerMoney(plus);
                player.setPlayerExp(addExp);
                player.setPlayerAmphetamine(deleteAmphet);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
    @RequestMapping("/SellHatterTHC")
    public String sellHatterTHC(Model model, Authentication authentication, Integer THC){
        Player player = playerRepository.find(authentication.getName());
        int cost = economyRepository.findById(1L).get().getPriceMarijuana();
        player.getId();
        Integer money = playerRepository.find(authentication.getName()).getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(50);
        int price = cost * THC;
        int plus = money + price;
        int exp = playerRepository.find(authentication.getName()).getPlayerExp();
        int addExp = exp + THC * 20;
        int THCplayer = playerRepository.find(authentication.getName()).getPlayerMarijuana();
        int deleteTHC = THCplayer - THC;
        if (THCplayer <= 0) {
            return "FailedBuy";
        } else {
            if (rnd <= 20) { // jeżeli ma trafić do więzienia  20%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRepository.save(player);
                return "redirect:Prison";
            } else { // jeżeli się powiodło
                player.setPlayerMoney(plus);
                player.setPlayerExp(addExp);
                player.setPlayerMarijuana(deleteTHC);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
    @RequestMapping("/SellHatterCOC")
    public String sellHatterCOC(Model model, Authentication authentication, Integer COC){
        Player player = playerRepository.find(authentication.getName());
        int cost = economyRepository.findById(1L).get().getPriceCocaine();
        player.getId();
        Integer money = playerRepository.find(authentication.getName()).getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(90);
        int price = cost * COC;
        int plus = money + price;
        int exp = playerRepository.find(authentication.getName()).getPlayerExp();
        int addExp = exp + COC * 45;
        int COCplayer = playerRepository.find(authentication.getName()).getPlayerCocaine();
        int deleteCOC = COCplayer - COC;
        if (COCplayer <= 0) {
            return "FailedBuy";
        } else {
            if (rnd <= 35) { // jeżeli ma trafić do więzienia  35%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRepository.save(player);
                return "redirect:Prison";
            } else { // jeżeli się powiodło
                player.setPlayerMoney(plus);
                player.setPlayerExp(addExp);
                player.setPlayerCocaine(deleteCOC);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
}
