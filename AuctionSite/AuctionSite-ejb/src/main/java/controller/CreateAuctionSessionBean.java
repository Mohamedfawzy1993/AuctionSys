package controller;

import model.dao.AuctionDao;
import model.entities.Auction;
import model.entities.Product;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class CreateAuctionSessionBean implements Serializable {

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

    public void createNewAuction()
    {


//        auction = new Auction();
//        System.out.println("After !!");
//        auction.setAuctiontitle("Title");
//        auction.setAuctiondescription("desc");
//        String strDatewithTime = "2015-08-04T10:11:30";
//
//        LocalDateTime aLDT = LocalDateTime.parse(strDatewithTime);
//        String loca = LocalDateTime.now().toString().split("\\.")[0];
//        LocalDateTime loc = LocalDateTime.parse(loca);
//        System.out.println("Date is :"+ loc.toString());
//
//        auction.setAuctionStart(loc);
//        auction.setAuctionEnd(loc.plusHours(24));
//        System.out.println("Before!!");
//        auction.setActive(true);
//        auctionDao.create(auction);
    }


}
