package be.vdab.wine.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp besteld;
    private String naam;
    private String straat;
    private String huisNr;
    private String postcode;
    private String gemeente;
    private int bestelwijze;
    @Version
    private long versie;

    @OneToMany
    @JoinColumn(name = "bonId")
    /*@OrderBy("aantal")*/
    private Set<Bestelbonlijn> bestelbonlijnen;

    public Bestelbon(Timestamp besteld, String naam, String straat,
                     String huisNr, String postcode, String gemeente, int bestelwijze, long versie) {
        this.besteld = besteld;
        this.naam = naam;
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.bestelwijze = bestelwijze;
        this.versie = versie;
    }
    protected Bestelbon() {

    }

    public long getId() {
        return id;
    }

    public Timestamp getBesteld() {
        return besteld;
    }

    public String getNaam() {
        return naam;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public int getBestelwijze() {
        return bestelwijze;
    }

    public long getVersie() {
        return versie;
    }
}
