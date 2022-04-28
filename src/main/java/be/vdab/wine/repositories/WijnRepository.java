package be.vdab.wine.repositories;

import be.vdab.wine.domain.Soort;
import be.vdab.wine.domain.Wijn;
import be.vdab.wine.dto.WijnEnAantal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class WijnRepository {
    private final EntityManager manager;

    public WijnRepository(EntityManager manager) {
        this.manager = manager;
    }

    public Optional<Wijn> findById(long id) {
        return Optional.ofNullable(manager.find(Wijn.class, id));
    }

    public List<Wijn> findBySoortId(long idVanSoort) {
        return manager.createNamedQuery("Wijn.findBySoortId", Wijn.class)
                .setParameter("id", idVanSoort)
                .setHint("javax.persistence.loadgraph",
                        manager.createEntityGraph(Wijn.MET_SOORT))
                .getResultList();
    }




}
