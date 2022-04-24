package be.vdab.wine.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BestelbonRepository {
    private final EntityManager manager;

    public BestelbonRepository(EntityManager manager) {
        this.manager = manager;
    }
}
