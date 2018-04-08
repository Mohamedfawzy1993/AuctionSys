package web;


import model.entities.Auction;
import model.entities.Product;

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

    public RegisterAuctionBean() {
        products = new ArrayList<>();
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
