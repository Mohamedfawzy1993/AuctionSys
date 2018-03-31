package model.dto2;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_sell_product", schema = "auctionsys", catalog = "")
public class UserSellProduct implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer auctionId;
    private Double sellStartPrice;

    @Id
    @Column(name = "user_sell_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "Product_id", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "auction_id", nullable = false)
    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    @Basic
    @Column(name = "sell_start_price", nullable = false, precision = 0)
    public Double getSellStartPrice() {
        return sellStartPrice;
    }

    public void setSellStartPrice(Double sellStartPrice) {
        this.sellStartPrice = sellStartPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSellProduct that = (UserSellProduct) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (auctionId != null ? !auctionId.equals(that.auctionId) : that.auctionId != null) return false;
        if (sellStartPrice != null ? !sellStartPrice.equals(that.sellStartPrice) : that.sellStartPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (auctionId != null ? auctionId.hashCode() : 0);
        result = 31 * result + (sellStartPrice != null ? sellStartPrice.hashCode() : 0);
        return result;
    }
}
