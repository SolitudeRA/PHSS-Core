package datasource.entity.subjects;

import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicAlbumEntity;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;

@DisplayName("MusicAlbumEntity test case")
public class MusicAlbumTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new MusicAlbumEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
