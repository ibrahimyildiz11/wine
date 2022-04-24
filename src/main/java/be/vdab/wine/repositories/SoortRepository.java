package be.vdab.wine.repositories;

import be.vdab.wine.domain.Soort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class SoortRepository {
    private final EntityManager manager;

    public SoortRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Optional<Soort> findById(long id) {
        return Optional.ofNullable(manager.find(Soort.class, id));
    }

    public List<Soort> findByLandId(long idVanLand) {
        return manager.createNamedQuery("Soort.findByLandId", Soort.class)
                .setParameter("id", idVanLand)
                .setHint("javax.persistence.loadgraph",
                        manager.createEntityGraph(Soort.MET_LAND))
                .getResultList();
    }
}
