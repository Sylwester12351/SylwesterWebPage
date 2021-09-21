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
public class HatterBuyController {
    /*
    Buy system and dynamic economy
     */

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private EconomyRepository economyRepository;
    @Autowired
    private PlayerRaportRepository playerRaportRepository;

    Random random = new Random();

    @GetMapping("/BuyHatter")
    public String buyHatter(Model model, Authentication authentication){
        LocalTime localTime = LocalTime.now();
        Boolean playerIsAlive = playerRepository.find(authentication.getName()).getPlayerAlive();
        LocalTime prisonTime = playerRepository.find(authentication.getName()).getPlayerTimeInPrison();
        Economy economy = economyRepository.findById(1L).get();
        model.addAttribute("eco", new Economy());
        model.addAttribute("COST", economyRepository.findAll());
        LocalTime nextUpdateTime = economyRepository.findById(1L).get().getPriceTimeToNextUpdate();
        System.out.println(nextUpdateTime);
        if (nextUpdateTime == null){
            economy.setPriceTimeToNextUpdate(localTime.plusSeconds(20));
            economyRepository.save(economy);
        }else if (nextUpdateTime.isBefore(LocalTime.now())){
            int ampMin = 30;
            int ampMax = 350;
            int bullMin = 300;
            int bullMax = 1550;
            int cocMin = 55;
            int cocMax = 630;
            int thcMin = 10;
            int thcMax = 310;

            int amph = (int)(Math.random()* ampMax + ampMin);
            int bullet = (int)(Math.random()* bullMax + bullMin);
            int cocaine = (int)(Math.random()* cocMax + cocMin);
            int thc = (int)(Math.random()* thcMax + thcMin);
            System.out.println(amph+" "+ bullet+ " "+ cocaine+ " "+ thc);
            economy.setPriceTimeToNextUpdate(localTime.plusSeconds(90));
            economy.setPriceAmphetamine(amph);
            economy.setPriceBullet(bullet);
            economy.setPriceCocaine(cocaine);
            economy.setPriceMarijuana(thc);
            economyRepository.save(economy);
        }

        if (prisonTime !=null) {
            if (prisonTime.isAfter(LocalTime.now())){
                return "redirect:Prison";
            }
        }
        System.out.println(playerIsAlive.booleanValue());
        if (playerIsAlive){
            return "BuyHatter";
        }else {
            return "DeadHatter";
        }
    }
    @RequestMapping("/BuyHatterAMF")
    public String buyHatterAmfet(Model model, Authentication authentication, Integer Amphet){
        Player player = playerRepository.find(authentication.getName());
        PlayerRaport playerRaport = new PlayerRaport();
        List<PlayerRaport> playerRaportList = new ArrayList<>();
        int cost = economyRepository.findById(1L).get().getPriceAmphetamine();
        player.getId();
        Integer money = player.getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(60);
        int price = cost * Amphet;
        int minus = money - price;
        int exp = player.getPlayerExp();
        int addExp = exp + Amphet * 30;
        int practice = player.getPlayerPractice();
        int addPractice = practice + Amphet * 30;
        int AmphetPlayer = player.getPlayerAmphetamine();
        int addAmphet = AmphetPlayer + Amphet;
        if (money < price){ // jeżeli nie można kupić
            return "FailedBuy";
        }else {
            if (rnd <= 28){ // jeżeli ma trafić do więzienia  28%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRaport.setPlayerMessage("Zakup amfetaminy nie udany");
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "redirect:Prison";
            }else { // jeżeli się powiodło
                player.setPlayerMoney(minus);
                player.setPlayerExp(addExp);
                player.setPlayerPractice(addPractice);
                player.setPlayerAmphetamine(addAmphet);
                playerRaport.setPlayerMessage("Zakup amfetaminy udany kupiłeś " + Amphet);
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
    @RequestMapping("/BuyHatterTHC")
    public String buyHatterTHC(Model model, Authentication authentication, Integer THC){
        Player player = playerRepository.find(authentication.getName());
        PlayerRaport playerRaport = new PlayerRaport();
        List<PlayerRaport> playerRaportList = new ArrayList<>();
        player.getId();
        int cost = economyRepository.findById(1L).get().getPriceMarijuana();
        Integer money = player.getPlayerMoney();
        int rnd = random.nextInt(101);
        int time = random.nextInt(50);
        int price = cost * THC;
        int minus = money - price;
        int exp = player.getPlayerExp();
        int practice = player.getPlayerPractice();
        int addExp = exp + THC * 20;
        int addPractice = practice + THC * 20;
        int THCPlayer = player.getPlayerMarijuana();
        int addTHC = THCPlayer + THC;
        if (money < price){ // jeżeli nie można kupić
            return "FailedBuy";
        }else {
            if (rnd <= 20){ // jeżeli ma trafić do więzienia 20%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRaport.setPlayerMessage("Zakup zielska nie udany");
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "redirect:Prison";
            }else { // jeżeli się powiodło
                System.out.println(rnd);
                player.setPlayerMoney(minus);
                player.setPlayerExp(addExp);
                player.setPlayerPractice(addPractice);
                player.setPlayerMarijuana(addTHC);
                playerRaport.setPlayerMessage("Zakup zielska udany kupiłeś " + THC);
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
    @RequestMapping("/BuyHatterCOC")
    public String buyHatterCOC(Model model, Authentication authentication, Integer COC){
        Player player = playerRepository.find(authentication.getName());
        PlayerRaport playerRaport = new PlayerRaport();
        List<PlayerRaport> playerRaportList = new ArrayList<>();
        player.getId();
        Integer money = player.getPlayerMoney();
        int cost = economyRepository.findById(1L).get().getPriceCocaine();
        int rnd = random.nextInt(101);
        int time = random.nextInt(90);
        int price = cost * COC;
        int minus = money - price;
        int exp = player.getPlayerExp();
        int practice = player.getPlayerPractice();
        int addExp = exp + COC * 45;
        int addPractice = practice + COC * 45;
        int COCPlayer = player.getPlayerCocaine();
        int addCOC = COCPlayer + COC;
        if (money < price){ // jeżeli nie można kupić
            return "FailedBuy";
        }else {
            if (rnd <= 35){ // jeżeli ma trafić do więzienia 35%
                System.out.println(rnd);
                LocalTime localTime = LocalTime.now();
                player.setPlayerTimeInPrison(localTime.plusSeconds(time));
                playerRaport.setPlayerMessage("Zakup kokainy nie udany");
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "redirect:Prison";
            }else { // jeżeli się powiodło
                player.setPlayerMoney(minus);
                player.setPlayerExp(addExp);
                player.setPlayerPractice(addPractice);
                player.setPlayerCocaine(addCOC);
                playerRaport.setPlayerMessage("Zakup kokainy udany kupiłeś " + COC);
                playerRaportList.add(playerRaport);
                player.setPlayerRaports(playerRaportList);
                playerRaportRepository.save(playerRaport);
                playerRepository.save(player);
                return "SuccesBuy";
            }
        }
    }
    @RequestMapping("/BuyHatterBULET")
    public String buyHatterBullet(Model model, Authentication authentication, Integer Bullet){
        Player player = playerRepository.find(authentication.getName());
        player.getId();
        Integer money = player.getPlayerMoney();
        int cost = economyRepository.findById(1L).get().getPriceBullet();
        int price = cost * Bullet;
        int minus = money - price;
        int BulletPlayer = player.getPlayerBullet();
        int addBullet = BulletPlayer + Bullet;
        if (money < price){ // jeżeli nie można kupić
            return "FailedBuy";
        }else {
            player.setPlayerMoney(minus);
            player.setPlayerBullet(addBullet);
            playerRepository.save(player);
            return "SuccesBuy";
        }
    }
    @RequestMapping("/BuyHatterARMR")
    public String buyHatterArmor(Model model, Authentication authentication, Integer Armor){
        Player player = playerRepository.find(authentication.getName());
        player.getId();
        Integer money = player.getPlayerMoney();
        int price = 20 * Armor;
        int minus = money - price;
        float ArmorPlayer = player.getPlayerArmor();
        float AddArmor = ArmorPlayer + Armor;

        if (money < price){ // jeżeli nie można kupić
            return "FailedBuy";
        }else {
            player.setPlayerMoney(minus);
            player.setPlayerArmor(AddArmor);
            playerRepository.save(player);
            return "SuccesBuy";
        }
    }
}
