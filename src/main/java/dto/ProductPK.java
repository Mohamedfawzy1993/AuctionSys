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
public class ProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "product_category_id")
    private int productCategoryId;

    public ProductPK() {
    }

    public ProductPK(int id, int productCategoryId) {
        this.id = id;
        this.productCategoryId = productCategoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) productCategoryId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductPK)) {
            return false;
        }
        ProductPK other = (ProductPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.productCategoryId != other.productCategoryId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.ProductPK[ id=" + id + ", productCategoryId=" + productCategoryId + " ]";
    }
    
}
