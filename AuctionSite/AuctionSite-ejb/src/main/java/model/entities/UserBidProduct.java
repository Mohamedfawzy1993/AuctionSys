package model.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_bid_product", schema = "auctionSys", catalog = "")
public class UserBidProduct {
    private int userBidId;
    private Double lastBid;
    private int auctionAuctionId;
    private int productProductId;
    private int userUserId;
    private Auction auctionByAuctionAuctionId;
    private Product productByProductProductId;
    private Users usersByUserUserId;

    @Id
    @Column(name = "user_bid_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getUserBidId() {
        return userBidId;
    }

    public void setUserBidId(int userBidId) {
        this.userBidId = userBidId;
    }

    @Basic
    @Column(name = "last_bid")
    public Double getLastBid() {
        return lastBid;
    }

    public void setLastBid(Double lastBid) {
        this.lastBid = lastBid;
    }

    @Basic
    @Column(name = "auction_auction_id")
    public int getAuctionAuctionId() {
        return auctionAuctionId;
    }

    public void setAuctionAuctionId(int auctionAuctionId) {
        this.auctionAuctionId = auctionAuctionId;
    }

    @Basic
    @Column(name = "Product_product_id")
    public int getProductProductId() {
        return productProductId;
    }

    public void setProductProductId(int productProductId) {
        this.productProductId = productProductId;
    }

    @Basic
    @Column(name = "user_user_id")
    public int getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBidProduct that = (UserBidProduct) o;

        if (userBidId != that.userBidId) return false;
        if (auctionAuctionId != that.auctionAuctionId) return false;
        if (productProductId != that.productProductId) return false;
        if (userUserId != that.userUserId) return false;
        if (lastBid != null ? !lastBid.equals(that.lastBid) : that.lastBid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userBidId;
        result = 31 * result + (lastBid != null ? lastBid.hashCode() : 0);
        result = 31 * result + auctionAuctionId;
        result = 31 * result + productProductId;
        result = 31 * result + userUserId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "auction_auction_id", referencedColumnName = "auction_id", nullable = false)
    public Auction getAuctionByAuctionAuctionId() {
        return auctionByAuctionAuctionId;
    }

    public void setAuctionByAuctionAuctionId(Auction auctionByAuctionAuctionId) {
        this.auctionByAuctionAuctionId = auctionByAuctionAuctionId;
    }

    @ManyToOne
    @JoinColumn(name = "Product_product_id", referencedColumnName = "product_id", nullable = false)
    public Product getProductByProductProductId() {
        return productByProductProductId;
    }

    public void setProductByProductProductId(Product productByProductProductId) {
        this.productByProductProductId = productByProductProductId;
    }

    @ManyToOne
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id", nullable = false)
    public Users getUsersByUserUserId() {
        return usersByUserUserId;
    }

    public void setUsersByUserUserId(Users usersByUserUserId) {
        this.usersByUserUserId = usersByUserUserId;
    }
}
