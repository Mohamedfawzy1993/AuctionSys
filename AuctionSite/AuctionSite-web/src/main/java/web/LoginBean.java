package web;

import controller.UserMessageController;
import model.entities.Auction;
import model.entities.UserBidProduct;
import model.entities.UserMessage;
import model.entities.Users;
import controller.LoginSessionBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @Inject
    private LoginSessionBean loginSessionBean;
    @Inject
    private UserMessageController userMessageController;
    private String email;
    private String password;

    private Users user;

    private DataModel<UserMessage> model;

    private int number = 100;
    private List<UserMessage> userMessages = new ArrayList<>();

    public LoginBean() {
        model = new ListDataModel<UserMessage>(userMessages);
    }


    public LoginSessionBean getLoginSessionBean() {
        return loginSessionBean;
    }

    public void setLoginSessionBean(LoginSessionBean loginSessionBean) {
        this.loginSessionBean = loginSessionBean;
    }

    public UserMessageController getUserMessageController() {
        return userMessageController;
    }

    public void setUserMessageController(UserMessageController userMessageController) {
        this.userMessageController = userMessageController;
    }

    public DataModel<UserMessage> getModel() {
        return model;
    }

    public void setModel(DataModel<UserMessage> model) {
        this.model = model;
    }

    public List<UserMessage> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(List<UserMessage> userMessages) {
        this.userMessages = userMessages;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users Users) {
        this.user = Users;
    }

    public String verifyUser() {
        user = loginSessionBean.VerifyUser(email, password);
        if (user != null) {
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getUsername());
            return "home";
        }
        return null;
    }

    public int getNumber() {
        return number;
    }

    public void getMassges() {
//        System.out.println("Incrementing....");
//            System.out.println("========== user message ========"+user.getUsername());
        if (user != null) {

            for ( UserMessage mess:  userMessageController.getMessagesOfUser(user)){
                userMessages.add(mess);
                System.out.println("User ->"+user+" , Message"+mess.getMessage());
                System.out.println(userMessages);
            }
        }
//        userMessageController.deleteMessagesOfUser(user);
        number++;
    }
    public boolean isLogin() {
        if (this.user == null) {
            return false;
        }

        return true;
    }
}
