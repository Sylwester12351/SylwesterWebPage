package Sylwester.SylwesterWebPage.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "eco")
public class Economy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "price_bullet")
    private int priceBullet;

    @Column(name = "price_amphetamine")
    private int priceAmphetamine;

    @Column(name = "price_marijuana")
    private int priceMarijuana;

    @Column(name = "price_cocaine")
    private int priceCocaine;

    @Column(name = "price_timetonextupdate")
    private LocalTime priceTimeToNextUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Economy economy = (Economy) o;
        return priceBullet == economy.priceBullet && priceAmphetamine == economy.priceAmphetamine && priceMarijuana == economy.priceMarijuana && priceCocaine == economy.priceCocaine && Objects.equals(id, economy.id) && Objects.equals(priceTimeToNextUpdate, economy.priceTimeToNextUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priceBullet, priceAmphetamine, priceMarijuana, priceCocaine, priceTimeToNextUpdate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPriceBullet() {
        return priceBullet;
    }

    public void setPriceBullet(int priceBullet) {
        this.priceBullet = priceBullet;
    }

    public int getPriceAmphetamine() {
        return priceAmphetamine;
    }

    public void setPriceAmphetamine(int priceAmphetamine) {
        this.priceAmphetamine = priceAmphetamine;
    }

    public int getPriceMarijuana() {
        return priceMarijuana;
    }

    public void setPriceMarijuana(int priceMarijuana) {
        this.priceMarijuana = priceMarijuana;
    }

    public int getPriceCocaine() {
        return priceCocaine;
    }

    public void setPriceCocaine(int priceCocaine) {
        this.priceCocaine = priceCocaine;
    }

    public LocalTime getPriceTimeToNextUpdate() {
        return priceTimeToNextUpdate;
    }

    public void setPriceTimeToNextUpdate(LocalTime priceTimeToNextUpdate) {
        this.priceTimeToNextUpdate = priceTimeToNextUpdate;
    }
}
