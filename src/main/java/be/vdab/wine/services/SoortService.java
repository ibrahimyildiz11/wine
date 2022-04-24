package be.vdab.wine.services;

import be.vdab.wine.domain.Soort;
import be.vdab.wine.repositories.SoortRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SoortService {
    private final SoortRepository soortRepository;

    public SoortService(SoortRepository soortRepository) {
        this.soortRepository = soortRepository;
    }

    public List<Soort> findByLandId(long idVanLand) {
        return soortRepository.findByLandId(idVanLand);
    }
}
