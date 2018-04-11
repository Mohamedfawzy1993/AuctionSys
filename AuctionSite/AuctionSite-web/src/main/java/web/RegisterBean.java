package web;


import model.entities.Users;
import controller.RegistrationSessionBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "registerBean")
@RequestScoped
public class RegisterBean {


    @Inject
    private RegistrationSessionBean registrationSessionBean;

    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBeanUser;

    private Users registeredUser;
    private String registerResult;
    private List<String> roles;

    public RegisterBean() {
        this.registeredUser = new Users();
        roles = new ArrayList<>();
        roles.add("Supplier");
        roles.add("Seller");
    }

    public String getRegisterResult() {
        return registerResult;
    }

    public void setRegisterResult(String registerResult) {
        this.registerResult = registerResult;
    }

    public Users getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(Users registeredUser) {
        this.registeredUser = registeredUser;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String saveUser() {

        registeredUser.setBalance(100.0);
        registrationSessionBean.setUser(registeredUser);
        registrationSessionBean.addUserToDatabase();
//        loginBeanUser.setUser(registeredUser);
//        loginBeanUser.setEmail(registeredUser.getEmail());
//        loginBeanUser.setPassword(registeredUser.getPassword());
        return "login";

    }
}
