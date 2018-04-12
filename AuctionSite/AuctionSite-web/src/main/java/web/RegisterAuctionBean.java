package web;


import controller.CreateAuctionSessionBean;
import model.entities.Auction;
import model.entities.Product;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Named(value = "registerAuctionBean")
@SessionScoped
public class RegisterAuctionBean implements Serializable {


    @Inject
    private CreateAuctionSessionBean createAuctionSessionBean;
    private Auction auction;
    private int duration ;
    private List<Product> products;
    private Product product = new Product();;
    private DataModel<Product> productsModel;

    @ManagedProperty(value = "#{LoginBean}}")
    private LoginBean loginBean;

    public RegisterAuctionBean() {

        System.out.println("Init Data");
        auction = new Auction();
        products = new ArrayList<>();
        productsModel = new CollectionDataModel<>(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DataModel<Product> getProductsModel() {
        return productsModel;
    }

    public void setProductsModel(DataModel<Product> productsModel) {
        this.productsModel = productsModel;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public void createAuction() {

        String loca = LocalDateTime.now().toString().split("\\.")[0];
        LocalDateTime loc = LocalDateTime.parse(loca);
        auction.setAuctionStart(loc);
        auction.setAuctionEnd(auction.getAuctionStart().plusHours(duration));
    }

    public void addProduct() {
        products.add(product);
        productsModel.setWrappedData(products);
        product = new Product();
    }

    public void removeProduct() {

        products.remove(productsModel.getRowData());
        productsModel.setWrappedData(products);
    }
}
