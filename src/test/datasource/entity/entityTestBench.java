package datasource.entity;

import org.junit.jupiter.api.*;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: Entity test bench design
 */

@DisplayName("Entity test bench...")
public class entityTestBench {
    private EntityManagerFactory entityManagerFactory;

    @BeforeAll
    void initAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("me.protogalaxy.PHSS");

    }

    @BeforeEach
    void init() {

    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    void tearDownAll() {
        entityManagerFactory.close();
    }
}
