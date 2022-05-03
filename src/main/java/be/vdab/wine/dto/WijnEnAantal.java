package be.vdab.wine.dto;

import java.math.BigDecimal;

public class WijnEnAantal {
    private final Long id;

    private final String landNaam;
    private final String soortNaam;
    private final int wijnJaar;
    private final int aantal;
    private final BigDecimal prijs;

    public WijnEnAantal(Long id, String landNaam, String soortNaam, int wijnJaar, int aantal, BigDecimal prijs) {
        this.id = id;
        this.landNaam = landNaam;
        this.soortNaam = soortNaam;
        this.wijnJaar = wijnJaar;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    public String getLandNaam() {
        return landNaam;
    }

    public String getSoortNaam() {
        return soortNaam;
    }

    public int getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public int getWijnJaar() {
        return wijnJaar;
    }

    public Long getId() {
        return id;
    }
}
