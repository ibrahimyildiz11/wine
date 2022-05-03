package be.vdab.wine.domain;

import be.vdab.wine.repositories.WijnRepository;
import be.vdab.wine.services.WijnService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


class WijnTest {
    private final static int INBESTELLING = 10;
    private Wijn wijn;
    private Soort soort;
    private Land land;

    @BeforeEach
    void beforeEach() {
        land = new Land("test", 1);
        soort= new Soort("test", 1,land);
        wijn = new Wijn(
                soort, 1999, 5, BigDecimal.TEN,1,0 );
    }

    @Test
    void verhoogInBestelling() {
        wijn.verhoogInBestelling(1);
        assertThat(wijn.getInBestelling()).isEqualByComparingTo(2);
    }

    @Test
    void verhoogInBestellingMet0Mislukt() {
        assertThatIllegalArgumentException().isThrownBy(() -> wijn.verhoogInBestelling(0));
    }

}