package be.vdab.wine.services;

import be.vdab.wine.domain.Bestelbonlijn;
import be.vdab.wine.repositories.BestelbonlijnRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BestelbonlijnService {
    private final BestelbonlijnRepository bestelbonlijnRepository;

    public BestelbonlijnService(BestelbonlijnRepository bestelbonlijnRepository) {
        this.bestelbonlijnRepository = bestelbonlijnRepository;
    }

    public void create(Bestelbonlijn bestelbonlijn) {
        bestelbonlijnRepository.create(bestelbonlijn);
    }
    public Optional<Bestelbonlijn> findById(long id) {
        return bestelbonlijnRepository.findById(id);
    }
    /*public List<Bestelbonlijn> findByWijnId(long idVanWijn) {
        return bestelbonlijnRepository.findByWijnId(idVanWijn);
    }*/

    /*public void save(Bestelbonlijn bestelbonlijn){
        bestelbonlijnRepository.save(bestelbonlijn);
    }*/
    /*public void add(Long wijnId, Long bestelbonId, int aantal, BigDecimal prijs) {

    }*/
}
