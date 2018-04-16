package web;


import controller.ManageAuctionSessionBean;
import controller.AuctionDataSessionBean;
import model.entities.Auction;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "AdminAuctionsReport")
@ApplicationScoped
public class AdminAuctionsReport implements Serializable {

    @Inject
    private ManageAuctionSessionBean manageAuctionSessionBean;

    @Inject
    private AuctionDataSessionBean auctionDataSessionBean;

    private List<Auction> auctionsList;
    private DataModel<Auction> model;

    public AdminAuctionsReport(){

    }

    public ManageAuctionSessionBean getManageAuctionSessionBean() {
        return manageAuctionSessionBean;
    }

    public void setManageAuctionSessionBean(ManageAuctionSessionBean manageAuctionSessionBean) {
        this.manageAuctionSessionBean = manageAuctionSessionBean;
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

    public AuctionDataSessionBean getAuctionDataSessionBean() {
        return auctionDataSessionBean;
    }

    public void setAuctionDataSessionBean(AuctionDataSessionBean auctionDataSessionBean) {
        this.auctionDataSessionBean = auctionDataSessionBean;
    }

    @PostConstruct
    public void init(){
        auctionsList = manageAuctionSessionBean.getAllAuctions();
        model = new ListDataModel<Auction>(auctionsList);
    }

}
