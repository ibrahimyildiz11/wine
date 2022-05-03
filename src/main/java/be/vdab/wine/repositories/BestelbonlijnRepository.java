package be.vdab.wine.repositories;

import be.vdab.wine.domain.Bestelbonlijn;
import be.vdab.wine.domain.Soort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class BestelbonlijnRepository {

    private final EntityManager manager;

    public BestelbonlijnRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Bestelbonlijn bestelbonlijn) {
        manager.persist(bestelbonlijn);
    }

    public Optional<Bestelbonlijn> findById(long id) {
        return Optional.ofNullable(manager.find(Bestelbonlijn.class, id));
    }
}
