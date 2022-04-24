package be.vdab.wine.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
}
