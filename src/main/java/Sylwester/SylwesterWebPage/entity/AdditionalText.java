package Sylwester.SylwesterWebPage.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AdditionalText {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "home_message")
    private String homeMessage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalText additionalText = (AdditionalText) o;
        return id == additionalText.id && Objects.equals(homeMessage, additionalText.homeMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeMessage);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHomeMessage() {
        return homeMessage;
    }

    public void setHomeMessage(String homeMessage) {
        this.homeMessage = homeMessage;
    }
}
