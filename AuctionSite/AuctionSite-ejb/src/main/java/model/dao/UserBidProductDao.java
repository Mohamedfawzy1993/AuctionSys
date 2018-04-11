package model.dao;

import model.entities.Auction;
import model.entities.UserBidProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserBidProductDao extends AbstractDao<UserBidProduct> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<UserBidProduct> auctionBidders(Auction auction)
    {
        Query query = getEntityManager().createQuery("select b from UserBidProduct b where b.auctionByAuctionAuctionId = :auction");
        query.setParameter("auction" , auction);
        List<UserBidProduct> userBidders = query.getResultList();
        return userBidders;
    }
}
