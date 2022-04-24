package be.vdab.wine.services;

import be.vdab.wine.domain.Bestelbonlijn;
import be.vdab.wine.repositories.BestelbonlijnRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BestelbonlijnService {
    private final BestelbonlijnRepository bestelbonlijnRepository;

    public BestelbonlijnService(BestelbonlijnRepository bestelbonlijnRepository) {
        this.bestelbonlijnRepository = bestelbonlijnRepository;
    }

    public Optional<Bestelbonlijn> findById(long id) {
        return bestelbonlijnRepository.findById(id);
    }
}
