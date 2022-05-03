package be.vdab.wine.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "wijnen")
@NamedEntityGraph(name = "Wijn.metSoort",
        attributeNodes = @NamedAttributeNode("soort"))
public class Wijn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "soortId")
    private Soort soort;
    public static final String MET_SOORT = "Wijn.metSoort";
    private int jaar;
    private int beoordeling;
    private BigDecimal prijs;
    private int inBestelling;
    @Version
    private long versie;

    @OneToMany(mappedBy = "wijn")

    /*@JoinColumn(name = "wijnId")
    @OrderBy("aantal")*/
    private Set<Bestelbonlijn> bestelbonlijns;


    public Wijn(Soort soort, int jaar, int beoordeling, BigDecimal prijs, int inBestelling, long versie) {
        this.soort = soort;
        this.jaar = jaar;
        this.beoordeling = beoordeling;
        this.prijs = prijs;
        this.inBestelling = inBestelling;
        this.versie = versie;
    }

    protected Wijn() {

    }

    public long getId() {
        return id;
    }

    public Soort getSoort() {
        return soort;
    }

    public int getJaar() {
        return jaar;
    }

    public int getBeoordeling() {
        return beoordeling;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public int getInBestelling() {
        return inBestelling;
    }

    public long getVersie() {
        return versie;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSoort(Soort soort) {
        this.soort = soort;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public void setBeoordeling(int beoordeling) {
        this.beoordeling = beoordeling;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public void setInBestelling(int inBestelling) {
        this.inBestelling = inBestelling;
    }

    public void setVersie(long versie) {
        this.versie = versie;
    }

    /*public void setBestelbonnen(Set<Bestelbon> bestelbonnen) {
        this.bestelbonnen = bestelbonnen;
    }*/
    /*public void setBestelbonlijnen(Set<Bestelbonlijn> bestelbonlijnen) {
        this.bestelbonlijnen = bestelbonlijnen;
    }*/

    public void verhoogInBestelling(int aantal) {
        if (aantal <= 0) {
            throw new IllegalArgumentException();
        }
        inBestelling = inBestelling + aantal;
    }
}
