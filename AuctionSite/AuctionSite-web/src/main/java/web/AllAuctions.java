package web;

import controller.TempAllAuctionsController;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named(value = "AllAuctions")
@ApplicationScoped
public class AllAuctions implements Serializable {

    @Inject
    private TempAllAuctionsController tempAllAuctionsController;
    List<Auction> auctionsList;
    private DataModel<Auction> model;

    public AllAuctions() {

    }

    public TempAllAuctionsController getTempAllAuctionsController() {
        return tempAllAuctionsController;
    }

    public void setTempAllAuctionsController(TempAllAuctionsController tempAllAuctionsController) {
        this.tempAllAuctionsController = tempAllAuctionsController;
    }

    public List<Auction> getAuctionsList() {
        return auctionsList;
    }

    public void setAuctionsList(List<Auction> auctionsList) {
        this.auctionsList = auctionsList;
    }

    public DataModel<Auction> getModel() {
        return model;
    }

    public void setModel(DataModel<Auction> model) {
        this.model = model;
    }

    @PostConstruct
    public void allAuctions() {
        auctionsList = tempAllAuctionsController.getAllActiveAuctions();
        model = new ListDataModel<Auction>(auctionsList);

        for (Auction auction : auctionsList) {
            System.out.println("+++++++++++++++AllAuctions.allAuctions()+++++++++++++++++++");
            System.out.println(auction);
            for (Product product : auction.getProductsByAuctionId()) {
                System.out.println("+++++++++++++++AllAuctions.product+++++++++++++++++++");
                System.out.println(product);
            }
            System.out.println("+++++++++++++++AllAuctions.userBidProduct+++++++++++++++++++");
            for (UserBidProduct userBidProduct : auction.getUserBidProductsByAuctionId()) {
                System.out.println(userBidProduct);
            }

        }

    }

}
