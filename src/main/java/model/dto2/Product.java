package model.dto2;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private Integer id;
    private String productName;
    private Integer productCategoryId;

    @Id
    @Column(name = "product_id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_name", nullable = false, length = 45)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Id
    @Column(name = "product_category_id", nullable = false)
    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productCategoryId != null ? !productCategoryId.equals(product.productCategoryId) : product.productCategoryId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productCategoryId != null ? productCategoryId.hashCode() : 0);
        return result;
    }
}
