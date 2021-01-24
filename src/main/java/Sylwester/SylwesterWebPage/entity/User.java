package Sylwester.SylwesterWebPage.entity;

import javax.persistence.*;
@Entity
@Table(name = "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true, length = 45)
        private String nick;

        @Column(nullable = false, length = 64)
        private String password;

        @Column(name = "first_name", nullable = false, length = 20)
        private String firstName;

        @Column(name = "last_name", nullable = false, length = 20)
        private String lastName;

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

    public Long getId() {
        return id;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
