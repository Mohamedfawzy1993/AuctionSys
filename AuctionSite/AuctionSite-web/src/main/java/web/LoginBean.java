package web;

import model.entities.Users;
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

    private Users Users;

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

    public Users getUser() {
        return Users;
    }

    public void setUser(Users Users) {
        this.Users = Users;
    }

    public String verifyUser()
    {
        Users = loginSessionBean.VerifyUser(email , password);
        if(Users != null)
        {
            System.out.println(Users.getEmail());
            System.out.println(Users.getPassword());
            System.out.println(Users.getUsername());
        return "home";
        }
        return null;
    }
}
