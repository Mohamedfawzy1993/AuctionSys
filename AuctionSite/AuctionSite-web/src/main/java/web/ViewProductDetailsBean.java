package web;

import controller.AuctionDataSessionBean;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Named("viewProduct")
@RequestScoped
public class ViewProductDetailsBean implements Serializable {


    @Inject
    private UserProducts userProducts;

    @Inject
    private AuctionDataSessionBean auctionDataSessionBean;

    private UserBidProduct highestBid;

    private Product product;


    public ViewProductDetailsBean() {
    }

    @PostConstruct
    public void settingValues()
    {
        if(userProducts != null)
        {
            product = userProducts.getProduct();
            if(product != null)
            {
                highestBid = auctionDataSessionBean.getHighestProductBid(product);
            }
        }
    }

    public UserProducts getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(UserProducts userProducts) {
        this.userProducts = userProducts;
    }

    public UserBidProduct getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(UserBidProduct highestBid) {
        this.highestBid = highestBid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String formater(LocalDateTime localDateTime)
    {
        return localDateTime.format(DateTimeFormatter.ofPattern("EEEE MMM dd yyyy hh:mm:ss a"));
    }
}
