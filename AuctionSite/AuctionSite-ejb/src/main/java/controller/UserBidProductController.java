package controller;

import model.dao.AuctionDao;
import model.dao.UserBidProductDao;
import model.dao.UserMessageDao;
import model.entities.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class UserBidProductController {

    @Inject
    private UserBidProductDao userBidProductDao;
    @Inject
    private UserMessageDao userMessageDao;
    @Inject
    private AdminControlSessionBean adminControlSessionBean;
    @Inject
    private AuctionDao auctionDao;


    private final int EXTEND_TIME = 3;




    public void makeNewPid(Users users, Auction auction, Product product, Double amount) {
        new UserBidProduct(amount, auction, product, users);
        userBidProductDao.create(new UserBidProduct(amount, auction, product, users));
        System.out.println("Error Check");
        notifyPrevPiders(auction, product, amount);

    }

    public void notifyPrevPiders(Auction auction, Product product, Double amount) {
        List<UserBidProduct> userBidProductlist = userBidProductDao.getLastNBids(auction, product);
        List<Integer> userID = new ArrayList<>();
        int count = 0;
        for (UserBidProduct oldUserBidProduct : userBidProductlist) {
            if(!userID.contains(oldUserBidProduct.getUsersByUserUserId().getUserId()) && count < 5)
            {
                count++;
                userMessageDao.create(new UserMessage("product : "+product.getProductName()+""
                        +"in Auction"+auction.getAuctiontitle()+
                        "got new bid with Value"+amount,
                        oldUserBidProduct.getUsersByUserUserId() , true));
                userID.add(oldUserBidProduct.getUsersByUserUserId().getUserId());
            }
        }

    }

    public boolean isLastBidder(Product product, Users user) {

        UserBidProduct userBidProduct = userBidProductDao.getLastBidder(product);
        return userBidProduct != null && userBidProduct.getUserBidId() == user.getUserId();
    }

    public boolean isHigherBidding(Product product, double bidValue) {
        UserBidProduct userBidProduct = adminControlSessionBean.getHighestProductBid(product);
        return userBidProduct != null && userBidProduct.getLastBid() < bidValue;
    }

    public void extendAuctionTime(Auction auction)
    {
        LocalDateTime timeNow = LocalDateTime.now().plusMinutes(5);
        LocalDateTime end = auction.getAuctionEnd();
        if(timeNow.isAfter(end))
        {
            auction.setAuctionEnd(auction.getAuctionEnd().plusMinutes(5));
            auctionDao.update(auction);
        }
    }

}
