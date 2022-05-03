package be.vdab.wine.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "landen")
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @Version
    private long versie;
    @OneToMany
    @JoinColumn(name = "landId")
    @OrderBy("naam")
    private Set<Soort> sorten;


    public Land(String naam, long versie) {
        this.naam = naam;
        this.versie = versie;
        this.sorten = new LinkedHashSet<>();
    }

    protected Land() {}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public long getVersie() {
        return versie;
    }

    public Set<Soort> getSorten() {
        return Collections.unmodifiableSet(sorten);
    }
    public boolean add(Soort soort) {
        if (soort == null) {
            throw new NullPointerException();
        }
        return sorten.add(soort);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Land land = (Land) o;
        return id == land.id && versie == land.versie && Objects.equals(naam, land.naam) && Objects.equals(sorten, land.sorten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, versie, sorten);
    }
}
