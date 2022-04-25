package be.vdab.wine.dto;

import java.math.BigDecimal;

public class WijnEnAantal {
    private final int wijnJaar;
    private final int aantal;
    private final BigDecimal prijs;

    public WijnEnAantal(int wijnJaar, int aantal, BigDecimal prijs) {

        this.wijnJaar = wijnJaar;
        this.aantal = aantal;
        this.prijs = prijs;
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
}
