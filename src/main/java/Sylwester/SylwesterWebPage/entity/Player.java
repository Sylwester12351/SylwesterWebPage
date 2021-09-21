package Sylwester.SylwesterWebPage.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
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

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "player_ID" ,nullable = false)
    private List<PlayerRaport> playerRaports;

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
    private float playerHp;

    @Column(name = "player_damage")
    private float playerDamage;

    @Column(name = "player_aimhead")
    private float playerAimHead;

    @Column(name = "player_aimbody")
    private float playerAimBody;

    @Column(name = "player_armor")
    private float playerArmor;

    @Column(name = "player_money")
    private int playerMoney;

    @Column(name = "player_bullet")
    private int playerBullet;

    @Column(name = "player_lvl")
    private int playerLvl;

    @Column(name = "player_exp")
    private int playerExp;

    @Column(name = "player_practice")
    private int playerPractice;

    @Column(name = "player_marijuana")
    private int playerMarijuana;

    @Column(name = "player_amphetamine")
    private int playerAmphetamine;

    @Column(name = "player_cocaine")
    private int playerCocaine;

    @Column(name = "player_testmode")
    private boolean playerTestMode;

    public List<PlayerRaport> getPlayerRaports() {
        return playerRaports;
    }

    public void setPlayerRaports(List<PlayerRaport> playerRaports) {
        this.playerRaports = playerRaports;
    }

    public float getPlayerDamage() {
        return playerDamage;
    }

    public void setPlayerDamage(float playerDamage) {
        this.playerDamage = playerDamage;
    }

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

    public float getPlayerHp() {
        return playerHp;
    }

    public void setPlayerHp(float playerHp) {
        this.playerHp = playerHp;
    }

    public float getPlayerArmor() {
        return playerArmor;
    }

    public void setPlayerArmor(float playerArmor) {
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

    public float getPlayerAimHead() {
        return playerAimHead;
    }

    public void setPlayerAimHead(float playerAimHead) {
        this.playerAimHead = playerAimHead;
    }

    public float getPlayerAimBody() {
        return playerAimBody;
    }

    public void setPlayerAimBody(float playerAimBody) {
        this.playerAimBody = playerAimBody;
    }

    public int getPlayerPractice() {
        return playerPractice;
    }

    public void setPlayerPractice(int playerPractice) {
        this.playerPractice = playerPractice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Float.compare(player.playerHp, playerHp) == 0 && Float.compare(player.playerDamage, playerDamage) == 0 && Float.compare(player.playerAimHead, playerAimHead) == 0 && Float.compare(player.playerAimBody, playerAimBody) == 0 && Float.compare(player.playerArmor, playerArmor) == 0 && playerMoney == player.playerMoney && playerBullet == player.playerBullet && playerLvl == player.playerLvl && playerExp == player.playerExp && playerPractice == player.playerPractice && playerMarijuana == player.playerMarijuana && playerAmphetamine == player.playerAmphetamine && playerCocaine == player.playerCocaine && playerTestMode == player.playerTestMode && id.equals(player.id) && playerRaports.equals(player.playerRaports) && playerAlive.equals(player.playerAlive) && playerTimeInPrison.equals(player.playerTimeInPrison) && playerInPrison.equals(player.playerInPrison) && playerNick.equals(player.playerNick) && playerLastAttacker.equals(player.playerLastAttacker) && playerKiller.equals(player.playerKiller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerRaports, playerAlive, playerTimeInPrison, playerInPrison, playerNick, playerLastAttacker, playerKiller, playerHp, playerDamage, playerAimHead, playerAimBody, playerArmor, playerMoney, playerBullet, playerLvl, playerExp, playerPractice, playerMarijuana, playerAmphetamine, playerCocaine, playerTestMode);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerRaports=" + playerRaports +
                ", playerAlive=" + playerAlive +
                ", playerTimeInPrison=" + playerTimeInPrison +
                ", playerInPrison=" + playerInPrison +
                ", playerNick='" + playerNick + '\'' +
                ", playerLastAttacker='" + playerLastAttacker + '\'' +
                ", playerKiller='" + playerKiller + '\'' +
                ", playerHp=" + playerHp +
                ", playerDamage=" + playerDamage +
                ", playerAimHead=" + playerAimHead +
                ", playerAimBody=" + playerAimBody +
                ", playerArmor=" + playerArmor +
                ", playerMoney=" + playerMoney +
                ", playerBullet=" + playerBullet +
                ", playerLvl=" + playerLvl +
                ", playerExp=" + playerExp +
                ", playerPractice=" + playerPractice +
                ", playerMarijuana=" + playerMarijuana +
                ", playerAmphetamine=" + playerAmphetamine +
                ", playerCocaine=" + playerCocaine +
                ", playerTestMode=" + playerTestMode +
                '}';
    }
}
