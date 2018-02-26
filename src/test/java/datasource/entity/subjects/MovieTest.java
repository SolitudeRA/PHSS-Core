package datasource.entity.subjects;

import datasource.entity.fileSystemCore.moviesLayer.MovieEntity;

import javax.persistence.EntityManager;

public class MovieTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new MovieEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
