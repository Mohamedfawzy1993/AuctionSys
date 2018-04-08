package model.dao;

import model.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductDao extends AbstractDao<Product> {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}