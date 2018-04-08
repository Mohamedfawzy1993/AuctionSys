package model.dao;

import model.entities.ProductCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CategoryDao extends AbstractDao<ProductCategory>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
