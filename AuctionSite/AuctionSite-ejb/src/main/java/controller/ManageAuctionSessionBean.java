package controller;

import model.dao.AuctionDao;
import model.entities.Auction;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class ManageAuctionSessionBean {

    @Inject
    private AuctionDao auctionDao;

    private Auction auction;

    public ManageAuctionSessionBean() { }


    public List<Auction> getAllActiveAuctions() {
        return auctionDao.getActiveAuctions();

    }

    public Auction getAuctionByID(String auctionid) {
        Auction resAuction;
        int id = Integer.parseInt(auctionid);
        resAuction = auctionDao.find(Auction.class, id);
        return resAuction;
    }
}

