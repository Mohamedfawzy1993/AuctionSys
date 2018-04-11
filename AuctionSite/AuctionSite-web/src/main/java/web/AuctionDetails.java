package web;

import controller.ProductController;
import controller.TempAllAuctionsController;
import controller.UserBidProductController;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "AuctionDetails")
@javax.faces.bean.SessionScoped
public class AuctionDetails implements Serializable {


    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBeanUser;

    @Inject
    private TempAllAuctionsController tempAllAuctionsController;

    @Inject
    private ProductController productController;

    @Inject
    private UserBidProductController userBidProductController;


    Auction auction;
    List<UserBidProduct> auctionBids = new ArrayList<>();
    public double amount;

    public UserBidProductController getUserBidProductController() {
        return userBidProductController;
    }

    public void setUserBidProductController(UserBidProductController userBidProductController) {
        this.userBidProductController = userBidProductController;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    //    private DataModel<Auction> model;


    public List<UserBidProduct> getAuctionBids() {
        return auctionBids;
    }

    public void setAuctionBids(List<UserBidProduct> auctionBids) {
        this.auctionBids = auctionBids;
    }

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

    public String goToAuction() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String selectedAuctionID = params.get("selectedAuction");
        auctionBids.clear();
        auction = tempAllAuctionsController.getAuctionByID(selectedAuctionID);
        for (Product product : auction.getProductsByAuctionId()) {
            UserBidProduct temp = tempAllAuctionsController.getMaxPid(auction, product);
            if (temp != null) {
                auctionBids.add(temp);
            }
        }
        return "auctionDetails";
    }

    public LoginBean getLoginBeanUser() {
        return loginBeanUser;
    }

    public void setLoginBeanUser(LoginBean loginBeanUser) {
        this.loginBeanUser = loginBeanUser;
    }

    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public String makeBid() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String selectedAuctionID = params.get("selectedAuction");
        String selectedProductID = params.get("selectedProduct");
        Product product = productController.getProductByID(selectedAuctionID);
        auction = tempAllAuctionsController.getAuctionByID(selectedAuctionID);
        userBidProductController.makeNewPid(loginBeanUser.getUser(), auction, product, amount);
        System.out.println(" *-*-*-*-**-*-* " + "selectedAuction : " + selectedAuctionID + " , selectedProduct  :  " + selectedProductID + " , amount  :  " + amount + " *-*-*-*-**-*-* " + loginBeanUser.getUser() + " *-*-*-*-**-*-* " + product);
        return "auctionDetails";
    }
}
