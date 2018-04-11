package model.dao;

import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Stateless
@Transactional
public class UserBidProductDao extends AbstractDao<UserBidProduct> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

//    public List<Auction> getActiveAuctions() {
//        Query query = getEntityManager().createQuery("select a from Auction  a where a.active =1");
//        List<Auction> auctionList = query.getResultList();
//
//        return auctionList;
//    }


    public List<UserBidProduct> auctionBidders(Auction auction) {
        Query query = getEntityManager().createQuery("select b from UserBidProduct b where b.auctionByAuctionAuctionId = :auction");
        query.setParameter("auction", auction);
        List<UserBidProduct> userBidders = query.getResultList();
        return userBidders;
    }

    public List<UserBidProduct> getLastNBids(Auction auction, Product product) {
        Query query = getEntityManager().createQuery("select b from UserBidProduct b where b.auctionByAuctionAuctionId = :auction and b.productByProductProductId = :product ORDER BY b.userBidId ASC").setMaxResults(5);
        query.setParameter("auction", auction).setParameter("product", product);
        List<UserBidProduct> userBidders = query.getResultList();
        return userBidders;
    }
}
