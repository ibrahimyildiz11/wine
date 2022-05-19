package be.vdab.wine.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate besteld;
    private String naam;

    @Embedded
    private Adres adres;
    private Integer bestelwijze;
    @Version
    private Long versie;

    public Bestelbon(LocalDate besteld, String naam, Adres adres, Integer bestelwijze) {
        this.besteld = besteld;
        this.naam = naam;
        this.adres = adres;
        this.bestelwijze = bestelwijze;
    }
    protected Bestelbon() {

    }

    public Long getId() {
        return id;
    }

    public LocalDate getBesteld() {
        return besteld;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public Integer getBestelwijze() {
        return bestelwijze;
    }

    public Long getVersie() {
        return versie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestelbon)) return false;
        Bestelbon bestelbon = (Bestelbon) o;
        return Objects.equals(id, bestelbon.id) && Objects.equals(besteld, bestelbon.besteld) &&
                Objects.equals(naam, bestelbon.naam) && Objects.equals(adres, bestelbon.adres)
                && Objects.equals(bestelwijze, bestelbon.bestelwijze) && Objects.equals(versie, bestelbon.versie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, besteld, naam, adres, bestelwijze, versie);
    }
}
