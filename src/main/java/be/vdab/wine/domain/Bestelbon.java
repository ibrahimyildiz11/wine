package be.vdab.wine.domain;

import javax.persistence.*;
import java.time.LocalDate;
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

    @OneToMany
    @JoinColumn(name = "bonId")
    /*@OrderBy("aantal")*/
    private Set<Bestelbonlijn> bestelbonlijnen;

    public Bestelbon(LocalDate besteld, String naam, Adres adres, Integer bestelwijze, Long versie) {
        this.besteld = besteld;
        this.naam = naam;
        this.adres = adres;
        this.bestelwijze = bestelwijze;
        this.versie = versie;
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
}
