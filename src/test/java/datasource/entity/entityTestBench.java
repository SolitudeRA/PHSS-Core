package datasource.entity;

import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicAlbumEntity;
import datasource.entity.subjects.MusicAlbumTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.junit.Test;
import org.junit.jupiter.api.*;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: Entity test bench design
 */

@DisplayName("Entity test bench...")
public class entityTestBench {
    @PersistenceContext
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @BeforeAll
    public void initAll() throws Exception{

    }

    @BeforeEach
    public void init(){

    }

    @Test
    public void musicAlbumTestCase(){
        entityManagerFactory = Persistence.createEntityManagerFactory("me.protogalaxy.PHSS");
        MusicAlbumTest musicAlbumTest = new MusicAlbumTest();
        entityManager = entityManagerFactory.createEntityManager();
        musicAlbumTest.beginTest(entityManager);
    }

    @AfterEach
    public void tearDown(){

    }

    @AfterAll
    public void tearDownAll(){
        entityManagerFactory.close();
    }
}
