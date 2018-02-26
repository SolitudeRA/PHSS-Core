package datasource.entity.subjects;

import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicTrackEntity;

import javax.persistence.EntityManager;

public class MusicTrackTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new MusicTrackEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
