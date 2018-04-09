package model.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(schema = "auctionsys")
public class Auction implements Serializable{
    private int auctionId;
    private String auctiontitle;
    private String auctiondescription;
    private LocalDateTime auctionStart;
    private LocalDateTime auctionEnd;
    private LocalDateTime lastBidTime;
    private boolean active;
    private Collection<Product> productsByAuctionId;
    private Collection<UserBidProduct> userBidProductsByAuctionId;

    @Id
    @Column(name = "auction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    @Basic
    @Column(name = "auctiontitle")
    public String getAuctiontitle() {
        return auctiontitle;
    }

    public void setAuctiontitle(String auctiontitle) {
        this.auctiontitle = auctiontitle;
    }

    @Basic
    @Column(name = "auctiondescription")
    public String getAuctiondescription() {
        return auctiondescription;
    }

    public void setAuctiondescription(String auctiondescription) {
        this.auctiondescription = auctiondescription;
    }

    @Basic(optional = true)
    @Column(name = "auction_start")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    public LocalDateTime getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(LocalDateTime auctionStart) {
        this.auctionStart = auctionStart;
    }

    @Basic(optional = true)
    @Column(name = "auction_end")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    public LocalDateTime getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(LocalDateTime auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    @Basic(optional = true)
    @Column(name = "last_bid_time")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    public LocalDateTime getLastBidTime() {
        return lastBidTime;
    }

    public void setLastBidTime(LocalDateTime lastBidTime) {
        this.lastBidTime = lastBidTime;
    }

    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auction auction = (Auction) o;

        if (auctionId != auction.auctionId) return false;
        if (active != auction.active) return false;
        if (auctiontitle != null ? !auctiontitle.equals(auction.auctiontitle) : auction.auctiontitle != null)
            return false;
        if (auctiondescription != null ? !auctiondescription.equals(auction.auctiondescription) : auction.auctiondescription != null)
            return false;
        if (auctionStart != null ? !auctionStart.equals(auction.auctionStart) : auction.auctionStart != null)
            return false;
        if (auctionEnd != null ? !auctionEnd.equals(auction.auctionEnd) : auction.auctionEnd != null) return false;
        if (lastBidTime != null ? !lastBidTime.equals(auction.lastBidTime) : auction.lastBidTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = auctionId;
        result = 31 * result + (auctiontitle != null ? auctiontitle.hashCode() : 0);
        result = 31 * result + (auctiondescription != null ? auctiondescription.hashCode() : 0);
        result = 31 * result + (auctionStart != null ? auctionStart.hashCode() : 0);
        result = 31 * result + (auctionEnd != null ? auctionEnd.hashCode() : 0);
        result = 31 * result + (lastBidTime != null ? lastBidTime.hashCode() : 0);
//        result = 31 * result + (int) active;
        return result;
    }

    @OneToMany(mappedBy = "auctionByAuctionAuctionId")
    public Collection<Product> getProductsByAuctionId() {
        return productsByAuctionId;
    }

    public void setProductsByAuctionId(Collection<Product> productsByAuctionId) {
        this.productsByAuctionId = productsByAuctionId;
    }

    @OneToMany(mappedBy = "auctionByAuctionAuctionId")
    public Collection<UserBidProduct> getUserBidProductsByAuctionId() {
        return userBidProductsByAuctionId;
    }

    public void setUserBidProductsByAuctionId(Collection<UserBidProduct> userBidProductsByAuctionId) {
        this.userBidProductsByAuctionId = userBidProductsByAuctionId;
    }
}
