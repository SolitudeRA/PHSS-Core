package me.protogalaxy.datasource;

import javax.persistence.*;

public class JPAUtil {
    @PersistenceContext
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("me.protogalaxy.PHSS");
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void close() {
        getEntityManagerFactory().close();
    }
}