package web;


import model.dto.Auction;
import model.dto.Product;
import model.dto.UserSellProduct;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named(value = "registerAuctionBean")
@RequestScoped
public class RegisterAuctionBean implements Serializable{

    private Auction auction;
    private List<Product> products;
    private List<UserSellProduct> userSellProducts;

    public RegisterAuctionBean() {
        products = new ArrayList<>();
        userSellProducts = new ArrayList<>();
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public void printIT()
    {
        System.out.println(auction.getAuctionDesc());
    }
}
