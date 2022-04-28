package be.vdab.wine.forms;

import be.vdab.wine.domain.Adres;

public class BestelbonForm {
    private final String naam;
    private final String straat;
    private final String huisNr;
    private final String postCode;
    private final String gemeente;
    /*private final Integer bestelwijze;*/

    private final Long aantal;

    public BestelbonForm(String naam, String straat, String huisNr, String postCode, String gemeente, Long aantal) {
        this.naam = naam;
        this.straat = straat;
        this.huisNr = huisNr;
        this.postCode = postCode;
        this.gemeente = gemeente;
        this.aantal = aantal;
    }



    public String getNaam() {
        return naam;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public Long getAantal() {
        return aantal;
    }
}
