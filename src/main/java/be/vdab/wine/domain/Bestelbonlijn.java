package be.vdab.wine.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "bestelbonlijnen")
public class Bestelbonlijn implements Serializable{
    @EmbeddedId
    private BestelbonlijnId bestelbonlijnId;

    private int aantal;
    private BigDecimal prijs;



    public Bestelbonlijn(BestelbonlijnId bestelbonlijnId, int aantal, BigDecimal prijs) {
        this.bestelbonlijnId = bestelbonlijnId;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    protected Bestelbonlijn() {

    }

    public BestelbonlijnId getBestelbonlijnId() {
        return bestelbonlijnId;
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
        return aantal == that.aantal && Objects.equals(bestelbonlijnId, that.bestelbonlijnId) && Objects.equals(prijs, that.prijs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestelbonlijnId, aantal, prijs);
    }
}
