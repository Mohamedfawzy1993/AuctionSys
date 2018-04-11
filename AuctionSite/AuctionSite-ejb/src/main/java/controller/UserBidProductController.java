package controller;

import model.dao.UserBidProductDao;
import model.entities.Auction;
import model.entities.Product;
import model.entities.UserBidProduct;
import model.entities.Users;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class UserBidProductController {

    @Inject
    private UserBidProductDao userBidProductDao;

    public void makeNewPid(Users users, Auction auction, Product product, Double amount) {
        new UserBidProduct(amount, auction, product, users);
        userBidProductDao.create(new UserBidProduct(amount, auction, product, users));

    }

}
