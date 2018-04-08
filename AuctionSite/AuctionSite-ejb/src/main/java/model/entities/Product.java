package model.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {
    private int productId;
    private String productName;
    private String productImg;
    private double sellStartPrice;
    private int count;
    private ProductCategory productCategoryByProductCategoryCategoryId;
    private Users usersByUsersUserId;
    private Auction auctionByAuctionAuctionId;
    private Collection<UserBidProduct> userBidProductsByProductId;

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_img")
    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    @Basic
    @Column(name = "sell_start_price")
    public double getSellStartPrice() {
        return sellStartPrice;
    }

    public void setSellStartPrice(double sellStartPrice) {
        this.sellStartPrice = sellStartPrice;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (Double.compare(product.sellStartPrice, sellStartPrice) != 0) return false;
        if (count != product.count) return false;

        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productImg != null ? !productImg.equals(product.productImg) : product.productImg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productImg != null ? productImg.hashCode() : 0);
        temp = Double.doubleToLongBits(sellStartPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + count;

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_category_category_id", referencedColumnName = "category_id", nullable = false)
    public ProductCategory getProductCategoryByProductCategoryCategoryId() {
        return productCategoryByProductCategoryCategoryId;
    }

    public void setProductCategoryByProductCategoryCategoryId(ProductCategory productCategoryByProductCategoryCategoryId) {
        this.productCategoryByProductCategoryCategoryId = productCategoryByProductCategoryCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "users_user_id", referencedColumnName = "user_id", nullable = false)
    public Users getUsersByUsersUserId() {
        return usersByUsersUserId;
    }

    public void setUsersByUsersUserId(Users usersByUsersUserId) {
        this.usersByUsersUserId = usersByUsersUserId;
    }

    @ManyToOne
    @JoinColumn(name = "auction_auction_id", referencedColumnName = "auction_id", nullable = false)
    public Auction getAuctionByAuctionAuctionId() {
        return auctionByAuctionAuctionId;
    }

    public void setAuctionByAuctionAuctionId(Auction auctionByAuctionAuctionId) {
        this.auctionByAuctionAuctionId = auctionByAuctionAuctionId;
    }

    @OneToMany(mappedBy = "productByProductProductId")
    public Collection<UserBidProduct> getUserBidProductsByProductId() {
        return userBidProductsByProductId;
    }

    public void setUserBidProductsByProductId(Collection<UserBidProduct> userBidProductsByProductId) {
        this.userBidProductsByProductId = userBidProductsByProductId;
    }
}
