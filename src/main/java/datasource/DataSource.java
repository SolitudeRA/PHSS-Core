package datasource;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class DataSource {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

}