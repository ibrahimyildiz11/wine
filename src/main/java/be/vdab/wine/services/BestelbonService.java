package be.vdab.wine.services;

import be.vdab.wine.domain.Bestelbon;
import be.vdab.wine.repositories.BestelbonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BestelbonService {
    private final BestelbonRepository bestelbonRepository;

    public BestelbonService(BestelbonRepository repository) {
        this.bestelbonRepository = repository;
    }

    public void create(Bestelbon bestelbon) {
        bestelbonRepository.create(bestelbon);
    }

    public Optional<Bestelbon> findById(long id) {
        return bestelbonRepository.findById(id);
    }
}
