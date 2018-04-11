package controller;

import model.dao.ProductDao;
import model.dao.UserBidProductDao;
import model.dao.UserDao;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AdminControlSessionBean {

    @Inject
    private UserBidProductDao userBidProductDao;
    @Inject
    private ProductDao productDao;

    public UserBidProduct getHighestProductBid(Product product) {
        double highestBid = -1;
        UserBidProduct highestBidUser = null;
        Product product1 = productDao.find(Product.class, product.getProductId());
        if (product1 != null)
            for (UserBidProduct userBidProduct : product1.getUserBidProductsByProductId()) {
                if (userBidProduct.getLastBid() > highestBid) {
                    highestBid = userBidProduct.getLastBid();
                    highestBidUser = userBidProduct;
                }

            }
        return highestBidUser;
    }

    public List<UserBidProduct> getAuctionWinners(Auction auction) {
        List<UserBidProduct> userBidProducts = new ArrayList<>();
        List<UserBidProduct> auctionBidders = userBidProductDao.auctionBidders(auction);


        UserBidProduct tempBidProduct = null;
        double highBid = -1;
        if (auctionBidders != null)
            for (Product product : auction.getProductsByAuctionId()) {
                for (UserBidProduct userBidProduct : auctionBidders) {
                    if (userBidProduct.getProductByProductProductId().getProductId() == product.getProductId()) {
                        if (userBidProduct.getLastBid() > highBid) {
                            highBid = userBidProduct.getLastBid();
                            tempBidProduct = userBidProduct;
                        }
                    }
                }
                userBidProducts.add(tempBidProduct);
                tempBidProduct = null;
                highBid = -1;
            }

        return userBidProducts;
    }


}
