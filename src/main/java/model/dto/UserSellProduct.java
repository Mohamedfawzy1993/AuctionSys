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
@Table(name = "user_sell_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSellProduct.findAll", query = "SELECT u FROM UserSellProduct u")
    , @NamedQuery(name = "UserSellProduct.findByUserSellId", query = "SELECT u FROM UserSellProduct u WHERE u.userSellId = :userSellId")
    , @NamedQuery(name = "UserSellProduct.findBySellStartPrice", query = "SELECT u FROM UserSellProduct u WHERE u.sellStartPrice = :sellStartPrice")})
public class UserSellProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_sell_id")
    private Integer userSellId;
    @Basic(optional = false)
    @Column(name = "sell_start_price")
    private double sellStartPrice;
    @JoinColumn(name = "Product_product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product productproductid;
    @JoinColumn(name = "auction_auction_id", referencedColumnName = "auction_id")
    @ManyToOne(optional = false)
    private Auction auctionAuctionId;
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userUserId;

    public UserSellProduct() {
    }

    public UserSellProduct(Integer userSellId) {
        this.userSellId = userSellId;
    }

    public UserSellProduct(Integer userSellId, double sellStartPrice) {
        this.userSellId = userSellId;
        this.sellStartPrice = sellStartPrice;
    }

    public Integer getUserSellId() {
        return userSellId;
    }

    public void setUserSellId(Integer userSellId) {
        this.userSellId = userSellId;
    }

    public double getSellStartPrice() {
        return sellStartPrice;
    }

    public void setSellStartPrice(double sellStartPrice) {
        this.sellStartPrice = sellStartPrice;
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
        hash += (userSellId != null ? userSellId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSellProduct)) {
            return false;
        }
        UserSellProduct other = (UserSellProduct) object;
        if ((this.userSellId == null && other.userSellId != null) || (this.userSellId != null && !this.userSellId.equals(other.userSellId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.UserSellProduct[ userSellId=" + userSellId + " ]";
    }
    
}
