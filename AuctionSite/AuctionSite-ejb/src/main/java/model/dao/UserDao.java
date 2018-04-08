package model.dao;

import model.entities.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class UserDao extends AbstractDao<Users> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public Users getUserByEmail(String email) {
        Users Users = null;
        if (email != null && !email.trim().isEmpty()) {
            email = email.trim();
            Query query = getEntityManager().createQuery("select u from Users u where u.email = :email");
            query.setParameter("email", email);
            List<Users> userList = query.getResultList();
            if(userList != null && userList.size() > 0)
            {
                Users = userList.get(0);
            }
        }
        return Users;
    }


}
