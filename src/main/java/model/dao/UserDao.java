package model.dao;

import model.dto.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDao implements DaoInterface<User> {

    EntityManager entityManager ;

    public UserDao ()
    {
        entityManager = EntityManagerProvider.getInstance().getEntityManager();
    }

    public List<User> select(User user) {
       return null;
    }

    public List<User> select(String query) {
        Query query1 = entityManager.createQuery(query);
        return query1.getResultList();
    }

    public List<User> selectByNamedQuery(String namedQuery, String value) {
       Query query = entityManager.createNamedQuery(namedQuery);
       if(value != null)
           query.setParameter(1 , value);
       return query.getResultList();
    }


    public void insert(User user) {

    }

    public void update(User user) {

    }

    public void delete(User user) {

    }
}
