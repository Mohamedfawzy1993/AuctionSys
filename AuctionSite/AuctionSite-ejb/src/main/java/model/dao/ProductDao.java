package model.dao;

import model.entities.Product;
import model.entities.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class ProductDao extends AbstractDao<Product> {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }


    public List<Product> getAllUserProducts(Users users) {
        if(users != null){
            Query query = getEntityManager().createQuery("select p from Product p where p.usersByUsersUserId = :user");
            query.setParameter("user" , users);
            return query.getResultList();
        }
        return null;
    }
}
