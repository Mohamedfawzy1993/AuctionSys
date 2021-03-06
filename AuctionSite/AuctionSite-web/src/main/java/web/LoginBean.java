package web;

import controller.UserMessageController;
import model.entities.UserMessage;
import model.entities.Users;
import controller.LoginSessionBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named(value = "loginBean")
@javax.enterprise.context.SessionScoped
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
    private List<UserMessage> userMessagesNotification = new ArrayList<>();

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

    public void getMassgesAsNOtification() {
        FacesContext context = FacesContext.getCurrentInstance();
        for ( UserMessage mess:  userMessagesNotification){
        context.addMessage(null, new FacesMessage("New bid",  mess.getMessage()) );
        }
        userMessagesNotification.clear();

    }
    public void getMassges() {
        if (user != null) {

            for (UserMessage mess : userMessageController.getMessagesOfUser(user)) {
                userMessages.add(mess);
                userMessagesNotification.add(mess);
                System.out.println("User ->"+user+" , Message"+mess.getMessage());
                System.out.println(userMessages);
            }
        }
        userMessageController.deleteMessagesOfUser(user);
        number++;
    }

    public boolean isLogin() {
        if (this.user == null) {
            return false;
        }

        return true;
    }

    public String logout() {
        user = null;
        return "home";
    }

    public boolean isAdmin() {
        return this.user != null && user.getRole().equals("admin");
    }

}
