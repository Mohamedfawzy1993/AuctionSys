package model.dao;

import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;
import java.util.List;


@Stateless
@Transactional
public class AuctionDao extends AbstractDao<Auction> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Auction> getActiveAuctions() {
        Query query = getEntityManager().createQuery("select a from Auction  a where a.active =1");
        List<Auction> auctionList = query.getResultList();
        for (Auction auction : auctionList) {
            System.out.println("------------AllAuctions.allAuctions()-----------------");
            System.out.println(auction);
            for (Product product : auction.getProductsByAuctionId()) {
                System.out.println("-----------------AllAuctions.product-----------------");
                System.out.println(product);
            }
            System.out.println("-----------------AllAuctions.userBidProduct-----------------");
            for (UserBidProduct userBidProduct : auction.getUserBidProductsByAuctionId()) {
                System.out.println(userBidProduct);
            }

        }
        return auctionList;
    }


}
