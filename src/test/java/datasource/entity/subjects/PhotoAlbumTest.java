package datasource.entity.subjects;

import datasource.entity.fileSystemCore.photoAlbumsLayer.PhotoAlbumEntity;

import javax.persistence.EntityManager;

public class PhotoAlbumTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new PhotoAlbumEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
