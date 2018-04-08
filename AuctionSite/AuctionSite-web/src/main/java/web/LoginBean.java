package web;

import model.dto.User;
import controller.LoginSessionBean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    @Inject
    private LoginSessionBean loginSessionBean;
    private String email;
    private String password;
    private User user;

    public LoginBean() {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String verifyUser()
    {
        user = loginSessionBean.VerifyUser(email , password);
        if(user != null)
        {
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getUsername());
        }
        return null;
    }
}
