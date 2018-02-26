package datasource;

import javax.persistence.*;

public class DataSource {
    @PersistenceContext
    private EntityManagerFactory entityManagerFactory;

    public DataSource(){
        entityManagerFactory = Persistence.createEntityManagerFactory("me.protogalaxy.PHSS");
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public void close(){
        entityManagerFactory.close();
    }
}