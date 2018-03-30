/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muhammed Fawzy
 */
@Entity
@Table(name = "user_sell_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSellProduct.findAll", query = "SELECT u FROM UserSellProduct u")
    , @NamedQuery(name = "UserSellProduct.findById", query = "SELECT u FROM UserSellProduct u WHERE u.userSellProductPK.id = :id")
    , @NamedQuery(name = "UserSellProduct.findByUserId", query = "SELECT u FROM UserSellProduct u WHERE u.userSellProductPK.userId = :userId")
    , @NamedQuery(name = "UserSellProduct.findByProductid", query = "SELECT u FROM UserSellProduct u WHERE u.userSellProductPK.productid = :productid")
    , @NamedQuery(name = "UserSellProduct.findByAuctionId", query = "SELECT u FROM UserSellProduct u WHERE u.userSellProductPK.auctionId = :auctionId")
    , @NamedQuery(name = "UserSellProduct.findBySellStartPrice", query = "SELECT u FROM UserSellProduct u WHERE u.sellStartPrice = :sellStartPrice")})
public class UserSellProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserSellProductPK userSellProductPK;
    @Basic(optional = false)
    @Column(name = "sell_start_price")
    private double sellStartPrice;
    @JoinColumn(name = "Product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "auction_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Auction auction;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public UserSellProduct() {
    }

    public UserSellProduct(UserSellProductPK userSellProductPK) {
        this.userSellProductPK = userSellProductPK;
    }

    public UserSellProduct(UserSellProductPK userSellProductPK, double sellStartPrice) {
        this.userSellProductPK = userSellProductPK;
        this.sellStartPrice = sellStartPrice;
    }

    public UserSellProduct(int id, int userId, int productid, int auctionId) {
        this.userSellProductPK = new UserSellProductPK(id, userId, productid, auctionId);
    }

    public UserSellProductPK getUserSellProductPK() {
        return userSellProductPK;
    }

    public void setUserSellProductPK(UserSellProductPK userSellProductPK) {
        this.userSellProductPK = userSellProductPK;
    }

    public double getSellStartPrice() {
        return sellStartPrice;
    }

    public void setSellStartPrice(double sellStartPrice) {
        this.sellStartPrice = sellStartPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userSellProductPK != null ? userSellProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSellProduct)) {
            return false;
        }
        UserSellProduct other = (UserSellProduct) object;
        if ((this.userSellProductPK == null && other.userSellProductPK != null) || (this.userSellProductPK != null && !this.userSellProductPK.equals(other.userSellProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.UserSellProduct[ userSellProductPK=" + userSellProductPK + " ]";
    }
    
}
