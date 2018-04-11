package model.dao;

import model.entities.UserBidProduct;
import model.entities.UserMessage;
import model.entities.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class UserMessageDao extends AbstractDao<UserMessage> {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<UserMessage> getMessagesOfUser(Users user) {
        List<UserMessage> userBidProductList = null;
        Query query = getEntityManager().createQuery("select m from UserMessage m where m.user =  :user");
        query.setParameter("user", user);
        userBidProductList = query.getResultList();
        return userBidProductList;
    }

    public void deleteMessagesOfUser(Users user) {
        Query query = getEntityManager().createQuery("delete from UserMessage m where m.user=:user");
        query.setParameter("user", user);
        query.getResultList();
    }

}
