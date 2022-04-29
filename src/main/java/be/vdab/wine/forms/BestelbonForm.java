package be.vdab.wine.forms;

public class BestelbonForm {
    private String naam;
    private final String straat;
    private final String huisNr;
    private final String postCode;
    private final String gemeente;
    private final Integer bestelwijze;

    private final Long aantal;

    public BestelbonForm(String naam, String straat, String huisNr, String postCode, String gemeente, Integer bestelwijze, Long aantal) {
        this.naam = naam;
        this.straat = straat;
        this.huisNr = huisNr;
        this.postCode = postCode;
        this.gemeente = gemeente;
        this.bestelwijze = bestelwijze;
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

    public Integer getBestelwijze() {
        return bestelwijze;
    }
}
