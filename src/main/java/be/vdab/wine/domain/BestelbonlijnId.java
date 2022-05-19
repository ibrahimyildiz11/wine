package be.vdab.wine.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BestelbonlijnId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bonId;
    private Long wijnId;

    public BestelbonlijnId(Long bonId, Long wijnId) {
        super();
        this.bonId = bonId;
        this.wijnId = wijnId;
    }

    public BestelbonlijnId() {

    }

    public Long getBonId() {
        return bonId;
    }

    public void setBonId(Long bonId) {
        this.bonId = bonId;
    }

    public Long getWijnId() {
        return wijnId;
    }

    public void setWijnId(Long wijnId) {
        this.wijnId = wijnId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BestelbonlijnId other = (BestelbonlijnId) obj;
        return Objects.equals(getWijnId(), other.getWijnId())
                && Objects.equals(getBonId(), other.getBonId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((wijnId == null) ? 0 : wijnId.hashCode());
        result = prime * result
                + ((bonId == null) ? 0 : bonId.hashCode());
        return result;
    }
}
