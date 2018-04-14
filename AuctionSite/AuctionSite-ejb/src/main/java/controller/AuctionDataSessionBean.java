package controller;

import model.dao.ProductDao;
import model.dao.UserBidProductDao;
import model.dao.UserDao;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;
import model.entities.Users;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class AuctionDataSessionBean {

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

    public List<UserBidProduct> getAllWinnedAuctions(Users user) {
        List<UserBidProduct> winnedBids = new ArrayList<>();
        List<UserBidProduct> userBidProducts = userBidProductDao.getUserExpiredAuctionBids(user);
        List<Integer> scannedBids = new ArrayList<>();


        System.out.println("UserBid is : "+userBidProducts == null);
        if(userBidProducts != null && userBidProducts.size()>0)
        {
            for(UserBidProduct userBidProduct : userBidProducts)
            {
                if(!scannedBids.contains(userBidProduct.getProductByProductProductId().getProductId()))
                {
                    System.out.println("Product is :"+userBidProduct.getProductByProductProductId().getProductName());
                    UserBidProduct highestProductWinner = getHighestProductBid(userBidProduct.getProductByProductProductId());
                    System.out.println("Highest Product Winner : "+highestProductWinner.getUsersByUserUserId().getUsername());
                    System.out.println("Current User is : "+user.getUsername());
                    System.out.println("Are They Equal : "+(highestProductWinner.getUsersByUserUserId() == user));
                    if(highestProductWinner != null && highestProductWinner.getUsersByUserUserId().getUserId() == user.getUserId())
                    {

                        winnedBids.add(userBidProduct);
                    }
                }
                scannedBids.add(userBidProduct.getProductByProductProductId().getProductId());
            }
        }
        return winnedBids;
    }


}
