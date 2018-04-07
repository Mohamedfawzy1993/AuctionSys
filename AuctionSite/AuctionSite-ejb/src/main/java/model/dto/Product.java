/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Muhammed Fawzy
 */
@Entity
@Table(name = "product")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
//    , @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId")
//    , @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    @JoinColumn(name = "product_category_category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private ProductCategory productCategoryCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productproductid")
    private List<UserSellProduct> userSellProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productproductid")
    private List<UserBidProduct> userBidProductList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getProductCategoryCategoryId() {
        return productCategoryCategoryId;
    }

    public void setProductCategoryCategoryId(ProductCategory productCategoryCategoryId) {
        this.productCategoryCategoryId = productCategoryCategoryId;
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
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Product[ productId=" + productId + " ]";
    }
    
}
