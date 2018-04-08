package web;


import model.dto.Auction;
import model.dto.Product;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "registerAuctionBean")
@RequestScoped
public class RegisterAuctionBean implements Serializable{

    private List<Product> productList;
    private Auction auction;
    private DataModel<Product> products;
    public RegisterAuctionBean() {
        auction = new Auction();
        productList = new ArrayList<>();
        products = new CollectionDataModel<>(productList);
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public void printIT()
    {

        System.out.println(auction.getAuctionDesc());

    }
}
