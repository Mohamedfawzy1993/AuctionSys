package model.dao;

import model.dto.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class UserDao extends AbstractDao<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public User getUserByEmail(String email) {
        User user = null;
        if (email != null && !email.trim().isEmpty()) {
            email = email.trim();
            Query query = getEntityManager().createQuery("select u from User u where u.email = :email");
            query.setParameter("email", email);
            List<User> userList = query.getResultList();
            if(userList != null && userList.size() > 0)
            {
                user = userList.get(0);
            }
        }
        return user;
    }


}
