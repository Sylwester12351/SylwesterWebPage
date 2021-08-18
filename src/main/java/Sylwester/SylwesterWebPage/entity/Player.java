package Sylwester.SylwesterWebPage.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @OneToOne(mappedBy = "player")
//    private User user;Time in prison

    @Column(name = "player_alive")
    private Boolean playerAlive = null;

    @Column(name = "player_timeinprison")
    private LocalTime playerTimeInPrison = null;

    @Column(name = "player_inprison")
    private Boolean playerInPrison = null;

    @Column(name = "player_nick", unique = true)
    private String playerNick;

    @Column(name = "player_lastattacker")
    private String playerLastAttacker;

    @Column(name = "player_killer")
    private String playerKiller;

    @Column(name = "player_hp")
    private int playerHp;

    @Column(name = "player_armor")
    private int playerArmor;

    @Column(name = "player_money")
    private int playerMoney;

    @Column(name = "player_bullet")
    private int playerBullet;

    @Column(name = "player_lvl")
    private int playerLvl;

    @Column(name = "player_exp")
    private int playerExp;

    @Column(name = "player_marijuana")
    private int playerMarijuana;

    @Column(name = "player_amphetamine")
    private int playerAmphetamine;

    @Column(name = "player_cocaine")
    private int playerCocaine;

    @Column(name = "player_testmode")
    private boolean playerTestMode;

    public boolean isPlayerTestMode() {
        return playerTestMode;
    }

    public void setPlayerTestMode(boolean playerTestMode) {
        this.playerTestMode = playerTestMode;
    }

    public Long getId() {
        return id;
    }

    public Boolean getPlayerInPrison() {
        return playerInPrison;
    }

    public void setPlayerInPrison(Boolean playerInPrison) {
        this.playerInPrison = playerInPrison;
    }

    public LocalTime getPlayerTimeInPrison() {
        return playerTimeInPrison;
    }

    public void setPlayerTimeInPrison(LocalTime playerTimeInPrison) {
        this.playerTimeInPrison = playerTimeInPrison;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public void setPlayerHp(int playerHp) {
        this.playerHp = playerHp;
    }

    public int getPlayerArmor() {
        return playerArmor;
    }

    public void setPlayerArmor(int playerArmor) {
        this.playerArmor = playerArmor;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getPlayerBullet() {
        return playerBullet;
    }

    public void setPlayerBullet(int playerBullet) {
        this.playerBullet = playerBullet;
    }

    public int getPlayerLvl() {
        return playerLvl;
    }

    public void setPlayerLvl(int playerLvl) {
        this.playerLvl = playerLvl;
    }

    public int getPlayerExp() {
        return playerExp;
    }

    public void setPlayerExp(int playerExp) {
        this.playerExp = playerExp;
    }

    public int getPlayerMarijuana() {
        return playerMarijuana;
    }

    public void setPlayerMarijuana(int playerMarijuana) {
        this.playerMarijuana = playerMarijuana;
    }

    public int getPlayerAmphetamine() {
        return playerAmphetamine;
    }

    public void setPlayerAmphetamine(int playerAmphetamine) {
        this.playerAmphetamine = playerAmphetamine;
    }

    public int getPlayerCocaine() {
        return playerCocaine;
    }

    public void setPlayerCocaine(int playerCocaine) {
        this.playerCocaine = playerCocaine;
    }

    public String getPlayerNick() {
        return playerNick;
    }

    public void setPlayerNick(String playerNick) {
        this.playerNick = playerNick;
    }

    public Boolean getPlayerAlive() {
        return playerAlive;
    }

    public void setPlayerAlive(Boolean playerAlive) {
        this.playerAlive = playerAlive;
    }

    public String getPlayerLastAttacker() {
        return playerLastAttacker;
    }

    public void setPlayerLastAttacker(String playerLastAttacker) {
        this.playerLastAttacker = playerLastAttacker;
    }

    public String getPlayerKiller() {
        return playerKiller;
    }

    public void setPlayerKiller(String playerKiller) {
        this.playerKiller = playerKiller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerHp == player.playerHp && playerArmor == player.playerArmor && playerMoney == player.playerMoney && playerBullet == player.playerBullet && playerLvl == player.playerLvl && playerExp == player.playerExp && playerMarijuana == player.playerMarijuana && playerAmphetamine == player.playerAmphetamine && playerCocaine == player.playerCocaine && id.equals(player.id) && playerAlive.equals(player.playerAlive) && playerNick.equals(player.playerNick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerAlive, playerNick, playerHp, playerArmor, playerMoney, playerBullet, playerLvl, playerExp, playerMarijuana, playerAmphetamine, playerCocaine);
    }
}
