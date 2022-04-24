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

    public List<Bestelbonlijn> findByWijnId(long idVanWijn) {
        return manager.createNamedQuery("Bestelbonlijn.findByWijnId", Bestelbonlijn.class)
                .setParameter("id", idVanWijn)
                .setHint("javax.persistence.loadgraph",
                        manager.createEntityGraph(Bestelbonlijn.MET_BESTELBON))
                .getResultList();
    }
}
