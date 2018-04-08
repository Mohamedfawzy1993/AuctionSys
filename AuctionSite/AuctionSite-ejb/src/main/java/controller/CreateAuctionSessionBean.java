package controller;

import model.dao.AuctionDao;
import model.entities.Auction;
import model.entities.Product;

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


    public CreateAuctionSessionBean() {
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }



}
