package web;


import controller.AuctionDataSessionBean;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named("joinedAuctions")
@RequestScoped
public class JoinedAuctionsBean {


    List<UserBidProduct> userBidProductList;

    @Inject
    private LoginBean loginBean;
    @Inject
    private AuctionDataSessionBean auctionDataSessionBean;


    public JoinedAuctionsBean() {
    }

    @PostConstruct
    public void settingParameters()
    {
        userBidProductList = auctionDataSessionBean.getAllJoinedAuctions(loginBean.getUser());
    }


    public List<UserBidProduct> getUserBidProductList() {
        return userBidProductList;
    }

    public void setUserBidProductList(List<UserBidProduct> userBidProductList) {
        this.userBidProductList = userBidProductList;
    }

    public String status(LocalDateTime localDateTime)
    {
        LocalDateTime now = LocalDateTime.now();
        if(now.isAfter(localDateTime))
        {
            return "Ended";
        }
        else
        {
            return "Still Running";
        }
    }

    public double highestProductBid(Product product)
    {
        UserBidProduct userBidProduct = auctionDataSessionBean.getHighestProductBid(product);
        if(userBidProduct != null)
            return userBidProduct.getLastBid();
        return 0.0;
    }
}
