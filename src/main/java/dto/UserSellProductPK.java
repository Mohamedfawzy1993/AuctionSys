/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Muhammed Fawzy
 */
@Embeddable
public class UserSellProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "Product_id")
    private int productid;
    @Basic(optional = false)
    @Column(name = "auction_id")
    private int auctionId;

    public UserSellProductPK() {
    }

    public UserSellProductPK(int id, int userId, int productid, int auctionId) {
        this.id = id;
        this.userId = userId;
        this.productid = productid;
        this.auctionId = auctionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) userId;
        hash += (int) productid;
        hash += (int) auctionId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSellProductPK)) {
            return false;
        }
        UserSellProductPK other = (UserSellProductPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.productid != other.productid) {
            return false;
        }
        if (this.auctionId != other.auctionId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.UserSellProductPK[ id=" + id + ", userId=" + userId + ", productid=" + productid + ", auctionId=" + auctionId + " ]";
    }
    
}
