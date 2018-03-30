
package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    , @NamedQuery(name = "Auction.findById", query = "SELECT a FROM Auction a WHERE a.id = :id")
    , @NamedQuery(name = "Auction.findByAuctionStart", query = "SELECT a FROM Auction a WHERE a.auctionStart = :auctionStart")
    , @NamedQuery(name = "Auction.findByAuctionEnd", query = "SELECT a FROM Auction a WHERE a.auctionEnd = :auctionEnd")
    , @NamedQuery(name = "Auction.findByLastBidTime", query = "SELECT a FROM Auction a WHERE a.lastBidTime = :lastBidTime")})
public class Auction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auction", fetch = FetchType.LAZY)
    private List<UserSellProduct> userSellProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auction", fetch = FetchType.LAZY)
    private List<UserBidProduct> userBidProductList;

    public Auction() {
    }

    public Auction(Integer id) {
        this.id = id;
    }

    public Auction(Integer id, Date auctionStart, Date auctionEnd) {
        this.id = id;
        this.auctionStart = auctionStart;
        this.auctionEnd = auctionEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.Auction[ id=" + id + " ]";
    }
    
}
