package web;

import controller.TempAllAuctionsController;
import model.entities.Auction;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named(value = "AuctionDetails")
@RequestScoped
    public class AuctionDetails implements Serializable {

    @Inject
    private TempAllAuctionsController tempAllAuctionsController;
    Auction auction;
//    private DataModel<Auction> model;

    public AuctionDetails() {

    }

    public TempAllAuctionsController getTempAllAuctionsController() {
        return tempAllAuctionsController;
    }

    public void setTempAllAuctionsController(TempAllAuctionsController tempAllAuctionsController) {
        this.tempAllAuctionsController = tempAllAuctionsController;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public String goToAuction( ) {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String selectedAuctionID = params.get("selectedAuction");
        auction= tempAllAuctionsController.getAuctionByID(selectedAuctionID);
        return "auctionDetails";
    }
}
