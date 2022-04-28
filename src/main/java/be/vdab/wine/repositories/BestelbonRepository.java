package be.vdab.wine.repositories;

import be.vdab.wine.domain.Bestelbon;
import be.vdab.wine.domain.Bestelbonlijn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class BestelbonRepository {
    private final EntityManager manager;

    public BestelbonRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Bestelbon bestelbon) {
        manager.persist(bestelbon);
    }

    public Optional<Bestelbon> findById(long id) {
        return Optional.ofNullable(manager.find(Bestelbon.class, id));
    }
}
