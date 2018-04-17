package model.dao;

import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;
import model.entities.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;
import java.time.LocalDateTime;
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
        String loc = LocalDateTime.now().toString();
        loc = loc.split("\\.")[0];
        LocalDateTime localDateTime = LocalDateTime.parse(loc);
        Query query = getEntityManager().createQuery("select a from Auction a where a.active = true and a.auctionEnd > :date ");
        query.setParameter("date" , localDateTime);
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

    public UserBidProduct getMaxPidForProductInAuction(Auction auction, Product product) {

        UserBidProduct userBidProduct = null;
        Query query = getEntityManager().createQuery("select ubp from UserBidProduct ubp where ubp.auctionByAuctionAuctionId = :auction and ubp.productByProductProductId=:product and ubp.lastBid = (select max(ubp2.lastBid) from UserBidProduct ubp2 where ubp2.auctionByAuctionAuctionId = :sub_auction and ubp2.productByProductProductId=:sub_product)");
        query.setParameter("auction", auction).setParameter("product", product).setParameter("sub_auction", auction).setParameter("sub_product", product);
        List<UserBidProduct> userBidProductList = query.getResultList();
        if (userBidProductList.size() > 0) {
            userBidProduct = userBidProductList.get(0);
        }
        return userBidProduct;
    }


    public List<Auction> getAuctions() {

        Query query = getEntityManager().createQuery("select a from Auction a where a.active = true");
        List<model.entities.Auction> auctionList = query.getResultList();
        if(auctionList != null && auctionList.size()>0)
        {
            for(Auction auction : auctionList )
            {
                for(Product product : auction.getProductsByAuctionId())
                {

                }
                for(UserBidProduct users : auction.getUserBidProductsByAuctionId())
                {
                    
                }
            }
        }
        return auctionList;
    }

}
