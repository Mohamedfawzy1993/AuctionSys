package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private EntityManager entityManager;
    private static EntityManagerProvider ourInstance = new EntityManagerProvider();

    public static EntityManagerProvider getInstance() {
        return ourInstance;
    }

    private EntityManagerProvider() {

    }


    public EntityManager getEntityManager() {
        entityManager = Persistence.createEntityManagerFactory("auctionJPA").createEntityManager();
        return entityManager;
    }

}
