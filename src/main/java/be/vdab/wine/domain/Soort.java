package be.vdab.wine.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "soorten")
@NamedEntityGraph(name = "Soort.metLand",
attributeNodes = @NamedAttributeNode("land"))
public class Soort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "landId")
    private Land land;
    public static final String MET_LAND = "Soort.metLand";

    @Version
    private long versie;

    @OneToMany
    @JoinColumn(name = "soortId")
    @OrderBy("jaar")
    private Set<Wijn> wijnen;

    public Soort(String naam, long versie, Land land) {
        this.naam = naam;
        this.versie = versie;
        setLand(land);
    }

    protected Soort(){

    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }


    public long getVersie() {
        return versie;
    }

    /*public Set<Land> getLanden() {
        return Collections.unmodifiableSet(landen);
    }*/

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        if (!land.getSorten().contains(this)) {
            land.add(this);
        }
        this.land = land;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soort)) return false;
        Soort soort = (Soort) o;
        return Objects.equals(naam, soort.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }
}
