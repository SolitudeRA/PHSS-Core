package datasource.entity.subjects;

import datasource.entity.fileSystemCore.illustrationLayer.IllustrationEntity;

import javax.persistence.EntityManager;

public class IllustrationTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new IllustrationEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
