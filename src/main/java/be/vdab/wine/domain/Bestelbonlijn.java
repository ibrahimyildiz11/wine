package be.vdab.wine.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "bestelbonlijnen")
/*@NamedEntityGraph(name = "Bestelbonlijn.metWijn",
        attributeNodes = @NamedAttributeNode("wijn"))
@NamedEntityGraph(name = "Bestelbonlijn.metBestelbon",
        attributeNodes = @NamedAttributeNode("bestelbon"))*/
public class Bestelbonlijn implements Serializable{
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bonId")
    private Bestelbon bestelbon;
    public static final String MET_BESTELBON = "Bestelbonlijn.metBestelbon";
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wijnId")
    private Wijn wijn;
    /*public static final String MET_WIJN = "Bestelbonlijn.metWijn";*/
    private int aantal;
    private BigDecimal prijs;



    public Bestelbonlijn(Bestelbon bestelbon, Wijn wijn, int aantal, BigDecimal prijs) {
        this.bestelbon = bestelbon;
        this.wijn = wijn;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    protected Bestelbonlijn() {
    }

    public Bestelbon getBestelbon() {
        return bestelbon;
    }

    public Wijn getWijn() {
        return wijn;
    }

    public int getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestelbonlijn)) return false;
        Bestelbonlijn that = (Bestelbonlijn) o;
        return aantal == that.aantal && Objects.equals(bestelbon, that.bestelbon) && Objects.equals(wijn, that.wijn) && Objects.equals(prijs, that.prijs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestelbon, wijn, aantal, prijs);
    }
}
