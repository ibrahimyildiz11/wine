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

    @OneToMany(mappedBy = "bestelbon")
    /*@JoinColumn(name = "bonId")*/
    /*@OrderBy("aantal")*/
    /*@JoinTable(
            name = "bestelbonlijnen",
            joinColumns = @JoinColumn(name = "bonId"),
            inverseJoinColumns = @JoinColumn(name = "wijnId"))*/
    private Set<Bestelbonlijn> bestelbonlijns;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setBesteld(LocalDate besteld) {
        this.besteld = besteld;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setBestelwijze(Integer bestelwijze) {
        this.bestelwijze = bestelwijze;
    }

    public void setVersie(Long versie) {
        this.versie = versie;
    }

    /*public void setWijnen(Set<Wijn> wijnen) {
        this.wijnen = wijnen;
    }*/
}
