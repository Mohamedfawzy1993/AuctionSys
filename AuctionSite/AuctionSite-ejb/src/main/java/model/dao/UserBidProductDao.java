package model.dao;

import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;
import model.entities.Users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
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

    public List<UserBidProduct> getAllProductBids(Auction auction, Product product) {
        Query query =
                getEntityManager()
                        .createQuery("select x from UserBidProduct x " +
                                "where x.auctionByAuctionAuctionId = :auction and x.productByProductProductId = :product " +
                                "ORDER BY x.userBidId ASC");
        query.setParameter("auction", auction).setParameter("product", product);
        List<UserBidProduct> userBidders = query.getResultList();
        return userBidders;
    }

    public UserBidProduct getLastBidder(Product product) {
        Query query = getEntityManager().createQuery("select b from UserBidProduct b where b.productByProductProductId = :product order by b.id desc");
        query.setParameter("product", product);
        List<UserBidProduct> userBidProductList = query.getResultList();
        UserBidProduct userBidProduct = null;
        if (userBidProductList != null && userBidProductList.size() > 0)
            userBidProduct = userBidProductList.get(0);
        return userBidProduct;
    }

    public List<UserBidProduct> getUserExpiredAuctionBids(Users user) {
        String loc = LocalDateTime.now().toString();
        loc = loc.split("\\.")[0];
        LocalDateTime localDateTime = LocalDateTime.parse(loc);

        Query query = getEntityManager().createQuery("select u from UserBidProduct u where u.auctionByAuctionAuctionId.auctionEnd < :date and u.usersByUserUserId = :user");
        query.setParameter("date", localDateTime);
        query.setParameter("user", user);

        List<UserBidProduct> userBidProducts = query.getResultList();
        return userBidProducts;
    }

    public UserBidProduct getUserBidProductObject(Users users, Product product) {
        Query query = entityManager.createQuery("select u from UserBidProduct u where" +
                " u.usersByUserUserId = :user and u.productByProductProductId = :product ");
        List<UserBidProduct> userBidProduct = query.getResultList();
        if (userBidProduct != null && userBidProduct.size() > 0)
            return userBidProduct.get(0);
        else
            return null;
    }
}
