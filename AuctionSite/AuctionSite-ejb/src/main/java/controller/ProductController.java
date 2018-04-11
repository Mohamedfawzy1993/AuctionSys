package controller;

import model.dao.AuctionDao;
import model.dao.ProductDao;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class ProductController {

    @Inject
    private ProductDao productDao;

    private Product product;


    public ProductController() {
    }


    public Product getProductByID(String productid) {
        Product resProduct;
        int id = Integer.parseInt(productid);
        resProduct = productDao.find(Product.class, id);
        return resProduct;
    }


}

