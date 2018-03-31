/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Muhammed Fawzy
 */
@Entity
@Table(name = "auction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auction.findAll", query = "SELECT a FROM Auction a")
    , @NamedQuery(name = "Auction.findByAuctionId", query = "SELECT a FROM Auction a WHERE a.auctionId = :auctionId")
    , @NamedQuery(name = "Auction.findByAuctionStart", query = "SELECT a FROM Auction a WHERE a.auctionStart = :auctionStart")
    , @NamedQuery(name = "Auction.findByAuctionEnd", query = "SELECT a FROM Auction a WHERE a.auctionEnd = :auctionEnd")
    , @NamedQuery(name = "Auction.findByLastBidTime", query = "SELECT a FROM Auction a WHERE a.lastBidTime = :lastBidTime")})
public class Auction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id")
    private Integer auctionId;
    @Basic(optional = false)
    @Column(name = "auction_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionStart;
    @Basic(optional = false)
    @Column(name = "auction_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionEnd;
    @Column(name = "last_bid_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastBidTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auctionAuctionId")
    private List<UserSellProduct> userSellProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auctionAuctionId")
    private List<UserBidProduct> userBidProductList;

    public Auction() {
    }

    public Auction(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Auction(Integer auctionId, Date auctionStart, Date auctionEnd) {
        this.auctionId = auctionId;
        this.auctionStart = auctionStart;
        this.auctionEnd = auctionEnd;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Date getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(Date auctionStart) {
        this.auctionStart = auctionStart;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Date getLastBidTime() {
        return lastBidTime;
    }

    public void setLastBidTime(Date lastBidTime) {
        this.lastBidTime = lastBidTime;
    }

    @XmlTransient
    public List<UserSellProduct> getUserSellProductList() {
        return userSellProductList;
    }

    public void setUserSellProductList(List<UserSellProduct> userSellProductList) {
        this.userSellProductList = userSellProductList;
    }

    @XmlTransient
    public List<UserBidProduct> getUserBidProductList() {
        return userBidProductList;
    }

    public void setUserBidProductList(List<UserBidProduct> userBidProductList) {
        this.userBidProductList = userBidProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionId != null ? auctionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.auctionId == null && other.auctionId != null) || (this.auctionId != null && !this.auctionId.equals(other.auctionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Auction[ auctionId=" + auctionId + " ]";
    }
    
}
