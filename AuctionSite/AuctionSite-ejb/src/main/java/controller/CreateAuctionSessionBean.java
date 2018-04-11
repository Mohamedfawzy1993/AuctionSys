package controller;

import model.dao.AuctionDao;
import model.dao.ProductDao;
import model.dao.UserBidProductDao;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;
import model.entities.Users;
import javax.ejb.Stateless;
import javax.inject.Inject;

import java.io.Serializable;

import java.util.List;

@Stateless
public class CreateAuctionSessionBean implements Serializable {

    @Inject
    private AuctionDao auctionDao;
    @Inject
    private ProductDao productDao;
    @Inject
    private UserBidProductDao userBidProductDao;
    private Auction auction;
    private Users user;
    private List<Product> products;

    public CreateAuctionSessionBean() {
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {

        this.auction = auction;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean createNewAuction() {

        if (user == null || auction == null || products == null) {
            return false;
        }

        auction.setActive(false);
        auctionDao.create(auction);

        boolean persistResult = createProducts(auction);
        if (persistResult) {
            auction.setProductsByAuctionId(products);
            auction.setActive(true);
            auctionDao.update(auction);
            createDefaultBids();
            persistResult = true;
        } else {
            persistResult = false;
        }
        return persistResult;
    }

    private boolean createProducts(Auction auction) {
        boolean result = false;
        for (Product product : products) {
            if (product != null) {
                product.setUsersByUsersUserId(user);
                product.setAuctionByAuctionAuctionId(auction);
                productDao.create(product);
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }

    private void createDefaultBids() {
        for(Product product : products)
        {
            if(product != null)
            {
                UserBidProduct userBidProduct = new UserBidProduct();
                userBidProduct.setAuctionByAuctionAuctionId(auction);
                userBidProduct.setProductByProductProductId(product);
                userBidProduct.setLastBid(product.getSellStartPrice());
                userBidProduct.setUsersByUserUserId(user);
                userBidProductDao.create(userBidProduct);
            }
        }

    }

}
