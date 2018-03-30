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
@Table(name = "user_bid_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBidProduct.findAll", query = "SELECT u FROM UserBidProduct u")
    , @NamedQuery(name = "UserBidProduct.findById", query = "SELECT u FROM UserBidProduct u WHERE u.userBidProductPK.id = :id")
    , @NamedQuery(name = "UserBidProduct.findByUserId", query = "SELECT u FROM UserBidProduct u WHERE u.userBidProductPK.userId = :userId")
    , @NamedQuery(name = "UserBidProduct.findByProductid", query = "SELECT u FROM UserBidProduct u WHERE u.userBidProductPK.productid = :productid")
    , @NamedQuery(name = "UserBidProduct.findByLastBid", query = "SELECT u FROM UserBidProduct u WHERE u.lastBid = :lastBid")
    , @NamedQuery(name = "UserBidProduct.findByAuctionId", query = "SELECT u FROM UserBidProduct u WHERE u.userBidProductPK.auctionId = :auctionId")})
public class UserBidProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserBidProductPK userBidProductPK;
    @Basic(optional = false)
    @Column(name = "last_bid")
    private double lastBid;
    @JoinColumn(name = "Product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "auction_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Auction auction;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public UserBidProduct() {
    }

    public UserBidProduct(UserBidProductPK userBidProductPK) {
        this.userBidProductPK = userBidProductPK;
    }

    public UserBidProduct(UserBidProductPK userBidProductPK, double lastBid) {
        this.userBidProductPK = userBidProductPK;
        this.lastBid = lastBid;
    }

    public UserBidProduct(int id, int userId, int productid, int auctionId) {
        this.userBidProductPK = new UserBidProductPK(id, userId, productid, auctionId);
    }

    public UserBidProductPK getUserBidProductPK() {
        return userBidProductPK;
    }

    public void setUserBidProductPK(UserBidProductPK userBidProductPK) {
        this.userBidProductPK = userBidProductPK;
    }

    public double getLastBid() {
        return lastBid;
    }

    public void setLastBid(double lastBid) {
        this.lastBid = lastBid;
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
        hash += (userBidProductPK != null ? userBidProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBidProduct)) {
            return false;
        }
        UserBidProduct other = (UserBidProduct) object;
        if ((this.userBidProductPK == null && other.userBidProductPK != null) || (this.userBidProductPK != null && !this.userBidProductPK.equals(other.userBidProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.UserBidProduct[ userBidProductPK=" + userBidProductPK + " ]";
    }
    
}
