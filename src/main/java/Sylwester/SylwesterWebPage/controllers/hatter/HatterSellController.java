package Sylwester.SylwesterWebPage.controllers.hatter;

import Sylwester.SylwesterWebPage.entity.Economy;
import Sylwester.SylwesterWebPage.entity.Player;
import Sylwester.SylwesterWebPage.entity.PlayerRaport;
import Sylwester.SylwesterWebPage.repository.EconomyRepository;
import Sylwester.SylwesterWebPage.repository.PlayerRaportRepository;
import Sylwester.SylwesterWebPage.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HatterSellController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private EconomyRepository economyRepository;
    @Autowired
    private PlayerRaportRepository playerRaportRepository;

    Random random = new Random();

    @GetMapping("/SellHatter")
    public String sellHatter(Model model, Authentication authentication){
        Player player = playerRepository.find(authentication.getName());
        LocalTime localTime = LocalTime.now();
        Boolean playerIsAlive = player.getPlayerAlive();
        LocalTime prisonTime = player.getPlayerTimeInPrison();
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
        PlayerRaport playerRaport = new PlayerRaport();
        List<PlayerRaport> playerRaportList = new ArrayList<>();
        int cost = economyRepository.findById(1L).get().getPriceAmphetamine();
        player.getId();
        Integer money = player.getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(60);
        int price = cost * Amphet;
        int plus = money + price;
        int exp = player.getPlayerExp();
        int practice = player.getPlayerPractice();
        int addExp = exp + Amphet * 30;
        int addPractice = practice + Amphet * 30;
        int AmphetPlayer = player.getPlayerAmphetamine();
        int deleteAmphet = AmphetPlayer - Amphet;
        if (AmphetPlayer <= 0) {
            return "FailedBuy";
        } else {
            if (rnd <= 28) { // jeżeli ma trafić do więzienia  28%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRaport.setPlayerMessage("Sprzedaż amfetaminy nie udany");
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "redirect:Prison";
            } else { // jeżeli się powiodło
                player.setPlayerMoney(plus);
                player.setPlayerExp(addExp);
                player.setPlayerPractice(addPractice);
                player.setPlayerAmphetamine(deleteAmphet);
                playerRaport.setPlayerMessage("Sprzedaż amfetaminy udany " + Amphet + " Zarobiłeś " + price );
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
    @RequestMapping("/SellHatterTHC")
    public String sellHatterTHC(Model model, Authentication authentication, Integer THC){
        Player player = playerRepository.find(authentication.getName());
        PlayerRaport playerRaport = new PlayerRaport();
        List<PlayerRaport> playerRaportList = new ArrayList<>();
        int cost = economyRepository.findById(1L).get().getPriceMarijuana();
        player.getId();
        Integer money = player.getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(50);
        int price = cost * THC;
        int plus = money + price;
        int exp = player.getPlayerExp();
        int practice = player.getPlayerPractice();
        int addExp = exp + THC * 20;
        int addPractice = practice + THC * 20;
        int THCplayer = player.getPlayerMarijuana();
        int deleteTHC = THCplayer - THC;
        if (THCplayer <= 0) {
            return "FailedBuy";
        } else {
            if (rnd <= 20) { // jeżeli ma trafić do więzienia  20%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRaport.setPlayerMessage("Sprzedaż zielska nie udany ");
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "redirect:Prison";
            } else { // jeżeli się powiodło
                player.setPlayerMoney(plus);
                player.setPlayerExp(addExp);
                player.setPlayerPractice(addPractice);
                player.setPlayerMarijuana(deleteTHC);
                playerRaport.setPlayerMessage("Sprzedaż zielska udany " + THC + " Zarobiłeś " + price);
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
    @RequestMapping("/SellHatterCOC")
    public String sellHatterCOC(Model model, Authentication authentication, Integer COC){
        Player player = playerRepository.find(authentication.getName());
        PlayerRaport playerRaport = new PlayerRaport();
        List<PlayerRaport> playerRaportList = new ArrayList<>();
        int cost = economyRepository.findById(1L).get().getPriceCocaine();
        player.getId();
        Integer money = player.getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(90);
        int price = cost * COC;
        int plus = money + price;
        int exp = player.getPlayerExp();
        int practice = player.getPlayerPractice();
        int addExp = exp + COC * 45;
        int addPractice = practice + COC * 45;
        int COCplayer = player.getPlayerCocaine();
        int deleteCOC = COCplayer - COC;
        if (COCplayer <= 0) {
            return "FailedBuy";
        } else {
            if (rnd <= 35) { // jeżeli ma trafić do więzienia  35%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRaport.setPlayerMessage("Sprzedaż kokainy nie udany");
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "redirect:Prison";
            } else { // jeżeli się powiodło
                player.setPlayerMoney(plus);
                player.setPlayerExp(addExp);
                player.setPlayerPractice(addPractice);
                player.setPlayerCocaine(deleteCOC);
                playerRaport.setPlayerMessage("Sprzedaż kokainy udany " + COC + " Zarobiłeś " + price );
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
}
