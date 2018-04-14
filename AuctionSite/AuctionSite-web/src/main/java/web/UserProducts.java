package web;


import controller.AuctionDataSessionBean;
import model.entities.Product;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("userProducts")
@RequestScoped
public class UserProducts {

    @Inject
    private AuctionDataSessionBean auctionDataSessionBean;

    @Inject
    private LoginBean loginBean;

    List<Product> products = new ArrayList<>();
    DataModel<Product> productDataModel ;
    public UserProducts() {

    }

    @PostConstruct
    private void initUserProducts()
    {
        System.out.println("init Product Object");
        if(loginBean != null) {
            products = auctionDataSessionBean.usersProducts(loginBean.getUser());
            System.out.println(products.size());
            productDataModel = new CollectionDataModel<>(products);
        }
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> setProducts) {
        this.products = products;
    }

    public DataModel<Product> getProductDataModel() {
        return productDataModel;
    }

    public void setProductDataModel(DataModel<Product> productDataModel) {
        this.productDataModel = productDataModel;
    }
}
