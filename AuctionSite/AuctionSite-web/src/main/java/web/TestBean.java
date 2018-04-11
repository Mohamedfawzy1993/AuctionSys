package web;

import controller.CreateAuctionSessionBean;
import controller.UserBidProductController;
import model.dao.CategoryDao;
import model.dao.UserDao;
import model.entities.Auction;
import model.entities.Product;
import model.entities.ProductCategory;
import model.entities.Users;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named("test")
@RequestScoped
public class TestBean implements Serializable {

    @Inject
    private CreateAuctionSessionBean createAuctionSessionBean;
    @Inject
    private UserDao userDao;
    @Inject
    private CategoryDao categoryDao;
    @Inject
    private UserBidProductController userBidProductController;

    public void test() {
        Auction auction = new Auction();
        auction.setAuctiontitle("Title");
        auction.setAuctiondescription("desc");
        auction.setActive(true);
        String loc = LocalDateTime.now().toString();
        loc = loc.split("\\.")[0];
        LocalDateTime localDateTime = LocalDateTime.parse(loc);
        auction.setAuctionStart(localDateTime);
//        auction.setAuctionEnd(auction.getAuctionStart().plusHours(10));
        auction.setAuctionEnd(auction.getAuctionStart().plusMinutes(2));

        Product product = new Product();
        product.setProductName("Productxxx");
        product.setCount(10);
        product.setSellStartPrice(100.1);

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        Users user = userDao.find(Users.class, 1);
        ProductCategory productCategory = categoryDao.find(ProductCategory.class , 1);
        product.setProductCategoryByProductCategoryCategoryId(productCategory);
        createAuctionSessionBean.setUser(user);
        createAuctionSessionBean.setProducts(productList);
        createAuctionSessionBean.setAuction(auction);
        createAuctionSessionBean.createNewAuction();
        System.out.println("Extending Auction Time ");
        userBidProductController.extendAuctionTime(auction);
    }
}
