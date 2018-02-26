package datasource.entity.subjects;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FilesystemInfMainEntity;

import javax.persistence.EntityManager;

public class FilesystemInfMainTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new FilesystemInfMainEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
