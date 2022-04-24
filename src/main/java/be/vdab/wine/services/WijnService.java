package be.vdab.wine.services;

import be.vdab.wine.domain.Wijn;
import be.vdab.wine.repositories.WijnRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WijnService {
    private final WijnRepository wijnRepository;

    public WijnService(WijnRepository wijnRepository) {
        this.wijnRepository = wijnRepository;
    }

    public Optional<Wijn> findById(long id) {
        return wijnRepository.findById(id);
    }
    public List<Wijn> findBySoortId(long idVanSoort) {
        return wijnRepository.findBySoortId(idVanSoort);
    }
}
