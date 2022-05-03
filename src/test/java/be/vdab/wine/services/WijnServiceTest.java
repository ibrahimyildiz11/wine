package be.vdab.wine.services;

import be.vdab.wine.domain.Land;
import be.vdab.wine.domain.Soort;
import be.vdab.wine.domain.Wijn;
import be.vdab.wine.exceptions.WijnNietGevondenException;
import be.vdab.wine.repositories.WijnRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WijnServiceTest {
    private WijnService service;
    @Mock
    private WijnRepository repository;
    private Wijn wijn;

    @BeforeEach
    void beforeEach() {
        service = new WijnService(repository);
        wijn = new Wijn(new Soort("test",0,
                new Land("test", 0)),
                1999, 5, BigDecimal.TEN,1,0 );
    }

    @Test
    void verhoogInBestelling() {
        when(repository.findById(1)).thenReturn(Optional.of(wijn));
        service.verhoogInBestelling(1, 10);
        assertThat(wijn.getInBestelling()).isEqualByComparingTo(11);
        verify(repository).findById(1);
    }

    @Test
    void verhoogInBestellingVoorOnbestaandeWijn() {
        assertThatExceptionOfType(WijnNietGevondenException.class).isThrownBy(
                () -> service.verhoogInBestelling(-1, 1));
        verify(repository).findById(-1);
    }

}