package datasource.entity.subjects;

import datasource.entity.fileSystemCore.photoAlbumsLayer.PhotoEntity;

import javax.persistence.EntityManager;

public class PhotoTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new PhotoEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
