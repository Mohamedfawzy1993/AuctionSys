package controller;

import model.dao.AuctionDao;
import model.dto.Auction;
import model.dto.Product;
import model.dto.UserSellProduct;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class CreateAuctionSessionBean {

    @Inject
    private AuctionDao auctionDao;
    private Auction auction;
    private List<UserSellProduct> userSellProducts;


    public CreateAuctionSessionBean() {
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public List<UserSellProduct> getUserSellProducts() {
        return userSellProducts;
    }

    public void setUserSellProducts(List<UserSellProduct> userSellProducts) {
        this.userSellProducts = userSellProducts;
    }


}
