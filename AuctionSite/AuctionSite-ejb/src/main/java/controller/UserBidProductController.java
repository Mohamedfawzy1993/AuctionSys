package controller;

import model.dao.UserBidProductDao;
import model.dao.UserMessageDao;
import model.entities.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class UserBidProductController {

    @Inject
    private UserBidProductDao userBidProductDao;
    @Inject
    private UserMessageDao userMessageDao;




    public void makeNewPid(Users users, Auction auction, Product product, Double amount) {
        new UserBidProduct(amount, auction, product, users);
        userBidProductDao.create(new UserBidProduct(amount, auction, product, users));
//        notifyPrevPiders(auction, product, amount);

    }

    public void notifyPrevPiders(Auction auction, Product product, Double amount) {
        List<UserBidProduct> userBidProductlist = userBidProductDao.getLastNBids(auction, product);
        for (UserBidProduct oldUserBidProduct : userBidProductlist) {
            userMessageDao.create(new UserMessage("product : "+product.getProductName()+""
                    +"in Auction"+auction.getAuctiontitle()+
                    "got new bid with Value"+amount,
                    oldUserBidProduct.getUsersByUserUserId()));

        }

    }

}
