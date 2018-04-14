package web;


import controller.CreateAuctionSessionBean;
import model.entities.Auction;
import model.entities.Product;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "registerAuctionBean")
@SessionScoped
public class RegisterAuctionBean implements Serializable {


    @Inject
    private CreateAuctionSessionBean createAuctionSessionBean;
    private Auction auction;
    private int duration;
    private List<Product> products;
    private List<String> durationTypeList;
    private Product product = new Product();
    private DataModel<Product> productsModel;

    private String auctiontitle;
    private String auctiondescription;
    private String durationType;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

    public AllAuctions getAllAuctions() {
        return allAuctions;
    }

    public void setAllAuctions(AllAuctions allAuctions) {
        this.allAuctions = allAuctions;
    }

    @ManagedProperty(value = "#{AllAuctions}")
    private AllAuctions allAuctions;


    public RegisterAuctionBean() {

        System.out.println("Init Data");
        products = new ArrayList<>();
        productsModel = new CollectionDataModel<>(products);
        durationTypeList = new ArrayList<>();
        durationTypeList.add("Minutes");
        durationTypeList.add("Hours");
        durationTypeList.add("Days");
    }

    public boolean isCreatedAuction() {
        if (auction == null)
            return true;
        return false;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DataModel<Product> getProductsModel() {
        return productsModel;
    }

    public void setProductsModel(DataModel<Product> productsModel) {
        this.productsModel = productsModel;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public String getAuctiontitle() {
        return auctiontitle;
    }

    public void setAuctiontitle(String auctiontitle) {
        this.auctiontitle = auctiontitle;
    }

    public String getAuctiondescription() {
        return auctiondescription;
    }

    public void setAuctiondescription(String auctiondescription) {
        this.auctiondescription = auctiondescription;
    }

    public List<String> getDurationTypeList() {
        return durationTypeList;
    }

    public void setDurationTypeList(List<String> durationTypeList) {
        this.durationTypeList = durationTypeList;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public int durationInMinutes() {
        int res = 0;
        switch (durationType) {
            case "Days":
                res = duration * 24 * 60;
                break;
            case "Hours":
                res = duration * 60;
                break;
            default:
                res = duration;
        }
        return res;
    }


    public void createAuction() {
        auction = new Auction();
        auction.setAuctiondescription(auctiondescription);
        auction.setAuctiontitle(auctiontitle);
        String loca = LocalDateTime.now().toString().split("\\.")[0];
        LocalDateTime loc = LocalDateTime.parse(loca);
        auction.setAuctionStart(loc);
        auction.setAuctionEnd(auction.getAuctionStart().plusMinutes(durationInMinutes()));
        System.out.println(auction + "actionType" + durationType);
        createAuctionSessionBean.setAuction(auction);
        createAuctionSessionBean.createNewAuction();
        System.out.println(auction.getAuctionEnd());

    }

    public void addProduct() {
        if (product.getProductName() != null && product.getProductName() != "" && !product.getProductName().isEmpty()) {
            System.out.println("product.getProductName()--->>"+product.getProductName());
            products.add(product);
            System.out.println("products in addProduct() : -->" + products);
            productsModel.setWrappedData(products);
            product = new Product();
        }

    }

    public void removeProduct() {
        System.out.println("/**/*/**/*/*/*/*/  removeProduct() /*/**/**/*/*/*//*");
        products.remove(productsModel.getRowData());
        productsModel.setWrappedData(products);
    }

    public CreateAuctionSessionBean getCreateAuctionSessionBean() {
        return createAuctionSessionBean;
    }

    public void setCreateAuctionSessionBean(CreateAuctionSessionBean createAuctionSessionBean) {
        this.createAuctionSessionBean = createAuctionSessionBean;
    }

    public void done() {
        if (products.size() > 0) {
            auction.setActive(true);
            auction.setProductsByAuctionId(products);
            System.out.println("createAuctionSessionBean : -->" + createAuctionSessionBean);
            System.out.println("loginBean : -->" + loginBean);
            System.out.println("products : -->" + products);
            createAuctionSessionBean.setProducts(products);
            createAuctionSessionBean.finishCreateAuction(auction, products, loginBean.getUser());
            allAuctions.addNewAuction(auction);
            auction = null;
            products.clear();
            auctiondescription = "";
            auctiontitle = "";
        }

    }
}
