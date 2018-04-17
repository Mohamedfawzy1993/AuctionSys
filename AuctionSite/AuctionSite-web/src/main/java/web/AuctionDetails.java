package web;

import controller.ManageAuctionSessionBean;
import controller.ProductController;
import controller.UserBidProductController;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "AuctionDetails")
@javax.faces.bean.SessionScoped
public class AuctionDetails implements Serializable {


    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBeanUser;

    @Inject
    private ManageAuctionSessionBean manageAuctionSessionBean;

    @Inject
    private ProductController productController;

    @Inject
    private UserBidProductController userBidProductController;


    private DataModel<UserBidProduct> model;
    private DataModel<UserBidProduct> modelHistory;

    private Auction auction;
    private List<UserBidProduct> auctionBids = new ArrayList<>();
    public double amount;

    public AuctionDetails() {


    }

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


    public List<UserBidProduct> getAuctionBids() {
        return auctionBids;
    }

    public void setAuctionBids(List<UserBidProduct> auctionBids) {
        this.auctionBids = auctionBids;
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

    public DataModel<UserBidProduct> getModel() {
        return model;
    }

    public void setModel(DataModel<UserBidProduct> model) {
        this.model = model;
    }

    public String goToAuction() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String selectedAuctionID = params.get("selectedAuction");
        auctionBids.clear();
        auction = manageAuctionSessionBean.getAuctionByID(selectedAuctionID);
        for (UserBidProduct u :
                auction.getUserBidProductsByAuctionId()) {
            System.out.print("222--->" + u.getLastBid() + " ");
        }
        for (Product product : auction.getProductsByAuctionId()) {
            System.out.println("the auction : " + auction.getAuctiontitle() + " has product --->" + product.getProductId() + " , " + product.getProductName());
            UserBidProduct temp = manageAuctionSessionBean.getMaxPid(auction, product);
            if (temp != null) {
                auctionBids.add(temp);
            }
        }
        model = new ListDataModel<UserBidProduct>(auctionBids);
        modelHistory = new ListDataModel<UserBidProduct>((List<UserBidProduct>) auction.getUserBidProductsByAuctionId());
        return "auctionDetails";
    }

    public String makeBid(UserBidProduct newPid) {

        System.out.println("*+*+*+ newPid -> " + newPid);
        auction = newPid.getAuctionByAuctionAuctionId();
        UserBidProduct usermaxBidProduct = manageAuctionSessionBean.getMaxPid(auction, newPid.getProductByProductProductId());
        System.out.println("------> max temp is : " + usermaxBidProduct.getLastBid());
        if (newPid.getLastBid() > usermaxBidProduct.getLastBid()) {
            userBidProductController.makeNewPid(loginBeanUser.getUser(), auction, newPid.getProductByProductProductId(), newPid.getLastBid());
            auction = manageAuctionSessionBean.getAuctionByID(""+newPid.getAuctionByAuctionAuctionId().getAuctionId());
            //we will use this paet if not ui updateble
            auctionBids.clear();
            for (Product product : auction.getProductsByAuctionId()) {
                UserBidProduct temp = manageAuctionSessionBean.getMaxPid(auction, product);
                if (temp != null) {
                    auctionBids.add(temp);
                }
            }

            model = new ListDataModel<UserBidProduct>(auctionBids);
            modelHistory = new ListDataModel<UserBidProduct>((List<UserBidProduct>) auction.getUserBidProductsByAuctionId());
        }
        return "auctionDetails";
    }

    public void updateDetailes() {
        auctionBids.clear();
        auction = manageAuctionSessionBean.getAuctionByID(""+auction.getAuctionId());
        for (Product product : auction.getProductsByAuctionId()) {
            UserBidProduct temp = manageAuctionSessionBean.getMaxPid(auction, product);
            if (temp != null) {
                auctionBids.add(temp);
            }
        }
        model = new ListDataModel<UserBidProduct>(auctionBids);
        modelHistory = new ListDataModel<UserBidProduct>((List<UserBidProduct>) auction.getUserBidProductsByAuctionId());
    }

    public DataModel<UserBidProduct> getModelHistory() {
        return modelHistory;
    }

    public void setModelHistory(DataModel<UserBidProduct> modelHistory) {
        this.modelHistory = modelHistory;
    }

    public String formater(LocalDateTime localDateTime)
    {
        return localDateTime.format(DateTimeFormatter.ofPattern("EEEE MMM dd yyyy hh:mm:ss a"));
    }
}
