package be.vdab.wine.repositories;

import be.vdab.wine.domain.Land;
import be.vdab.wine.domain.Soort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest(showSql = false)
@Sql("/insertSoort.sql")
@Import(SoortRepository.class)
class SoortRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final SoortRepository repository;
    private final EntityManager manager;

    SoortRepositoryTest(SoortRepository repository, EntityManager manager) {
        this.repository = repository;
        this.manager = manager;
    }
    private long idVanTest() {
        return jdbcTemplate.queryForObject(
                "select id from soorten where naam = 'test'", Long.class);
    }

    @Test
    void findById() {
        assertThat(repository.findById(idVanTest()))
                .hasValueSatisfying(
                        soort -> assertThat(soort.getNaam()).isEqualTo("test"));
    }

    @Test
    void findByOnbestaandeId() {
        assertThat(repository.findById(-1)).isEmpty();
    }

    @Test
    void findByLandId() {
        var soorten = repository.findByLandId(idVanTest());
        manager.clear();
        assertThat(soorten)
                .hasSize(countRowsInTableWhere("soorten","landId =" + idVanTest()))
                .allSatisfy(soort -> assertThat(soort.getLand().getId()).isEqualTo(1L));
    }
}