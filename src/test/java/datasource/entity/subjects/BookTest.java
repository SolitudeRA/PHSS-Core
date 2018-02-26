package datasource.entity.subjects;

import datasource.entity.fileSystemCore.booksLayer.BookEntity;

import javax.persistence.EntityManager;

public class BookTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new BookEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
