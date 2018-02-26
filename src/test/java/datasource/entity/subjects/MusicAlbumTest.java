package datasource.entity.subjects;

import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicAlbumEntity;

import javax.persistence.EntityManager;

public class MusicAlbumTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new MusicAlbumEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
