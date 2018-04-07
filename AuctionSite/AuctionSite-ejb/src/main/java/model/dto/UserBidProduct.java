/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
//@NamedQueries({
//    @NamedQuery(name = "UserBidProduct.findAll", query = "SELECT u FROM UserBidProduct u")
//    , @NamedQuery(name = "UserBidProduct.findByUserBidId", query = "SELECT u FROM UserBidProduct u WHERE u.userBidId = :userBidId")
//    , @NamedQuery(name = "UserBidProduct.findByLastBid", query = "SELECT u FROM UserBidProduct u WHERE u.lastBid = :lastBid")})
public class UserBidProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_bid_id")
    private Integer userBidId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "last_bid")
    private Double lastBid;
    @JoinColumn(name = "Product_product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product productproductid;
    @JoinColumn(name = "auction_auction_id", referencedColumnName = "auction_id")
    @ManyToOne(optional = false)
    private Auction auctionAuctionId;
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userUserId;

    public UserBidProduct() {
    }

    public UserBidProduct(Integer userBidId) {
        this.userBidId = userBidId;
    }

    public Integer getUserBidId() {
        return userBidId;
    }

    public void setUserBidId(Integer userBidId) {
        this.userBidId = userBidId;
    }

    public Double getLastBid() {
        return lastBid;
    }

    public void setLastBid(Double lastBid) {
        this.lastBid = lastBid;
    }

    public Product getProductproductid() {
        return productproductid;
    }

    public void setProductproductid(Product productproductid) {
        this.productproductid = productproductid;
    }

    public Auction getAuctionAuctionId() {
        return auctionAuctionId;
    }

    public void setAuctionAuctionId(Auction auctionAuctionId) {
        this.auctionAuctionId = auctionAuctionId;
    }

    public User getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(User userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userBidId != null ? userBidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBidProduct)) {
            return false;
        }
        UserBidProduct other = (UserBidProduct) object;
        if ((this.userBidId == null && other.userBidId != null) || (this.userBidId != null && !this.userBidId.equals(other.userBidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.UserBidProduct[ userBidId=" + userBidId + " ]";
    }
    
}
