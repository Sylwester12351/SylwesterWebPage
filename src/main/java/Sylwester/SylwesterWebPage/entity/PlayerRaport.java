package Sylwester.SylwesterWebPage.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player_raport")
public class PlayerRaport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "player_message")
    private String playerMessage;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerMessage() {
        return playerMessage;
    }

    public void setPlayerMessage(String playerMessage) {
        this.playerMessage = playerMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRaport that = (PlayerRaport) o;
        return id.equals(that.id) && playerMessage.equals(that.playerMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerMessage);
    }

    @Override
    public String toString() {
        return "PlayerRaport{" +
                "id=" + id +
                ", playerMessage='" + playerMessage + '\'' +
                '}';
    }
}
