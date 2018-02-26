package datasource.entity.subjects;

import datasource.entity.fileSystemCore.moviesLayer.AnimeEntity;

import javax.persistence.EntityManager;

public class AnimeTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new AnimeEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
