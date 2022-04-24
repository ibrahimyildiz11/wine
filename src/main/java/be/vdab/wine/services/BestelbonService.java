package be.vdab.wine.services;

import be.vdab.wine.repositories.BestelbonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BestelbonService {
    private final BestelbonRepository bestelbonRepository;

    public BestelbonService(BestelbonRepository repository) {
        this.bestelbonRepository = repository;
    }
}
