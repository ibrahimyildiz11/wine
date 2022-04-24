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

    @OneToMany
    @JoinColumn(name = "wijnId")
    /*@OrderBy("aantal")*/
    private Set<Bestelbonlijn> bestelbonlijnen;


    public Wijn(Soort soort, int jaar, int beordeling, BigDecimal prijs, int inBestelling, long versie) {
        this.soort = soort;
        this.jaar = jaar;
        this.beoordeling = beordeling;
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

    public int getBeordeling() {
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
}
