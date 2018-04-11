package web;

import controller.ManageAuctionSessionBean;
import model.entities.Auction;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named(value = "AuctionDetails")
@RequestScoped
    public class AuctionDetails implements Serializable {

    @Inject
    private ManageAuctionSessionBean manageAuctionSessionBean;
    Auction auction;
//    private DataModel<Auction> model;

    public AuctionDetails() {

    }

    public ManageAuctionSessionBean getManageAuctionSessionBean() {
        return manageAuctionSessionBean;
    }

    public void setManageAuctionSessionBean(ManageAuctionSessionBean manageAuctionSessionBean) {
        this.manageAuctionSessionBean = manageAuctionSessionBean;
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
        auction= manageAuctionSessionBean.getAuctionByID(selectedAuctionID);
        return "auctionDetails";
    }
}
