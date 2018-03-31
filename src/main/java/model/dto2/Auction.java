package model.dto2;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Auction implements Serializable {
    private Integer id;
    private Timestamp auctionStart;
    private Timestamp auctionEnd;
    private Timestamp lastBidTime;

    @Id
    @Column(name = "auction_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "auction_start", nullable = false)
    public Timestamp getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(Timestamp auctionStart) {
        this.auctionStart = auctionStart;
    }

    @Basic
    @Column(name = "auction_end", nullable = false)
    public Timestamp getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Timestamp auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    @Basic
    @Column(name = "last_bid_time", nullable = true)
    public Timestamp getLastBidTime() {
        return lastBidTime;
    }

    public void setLastBidTime(Timestamp lastBidTime) {
        this.lastBidTime = lastBidTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auction auction = (Auction) o;

        if (id != null ? !id.equals(auction.id) : auction.id != null) return false;
        if (auctionStart != null ? !auctionStart.equals(auction.auctionStart) : auction.auctionStart != null)
            return false;
        if (auctionEnd != null ? !auctionEnd.equals(auction.auctionEnd) : auction.auctionEnd != null) return false;
        if (lastBidTime != null ? !lastBidTime.equals(auction.lastBidTime) : auction.lastBidTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (auctionStart != null ? auctionStart.hashCode() : 0);
        result = 31 * result + (auctionEnd != null ? auctionEnd.hashCode() : 0);
        result = 31 * result + (lastBidTime != null ? lastBidTime.hashCode() : 0);
        return result;
    }
}
