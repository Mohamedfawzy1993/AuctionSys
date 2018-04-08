package web;


import model.dto.User;
import controller.RegistrationSessionBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "registerBean")
@RequestScoped
public class RegisterBean {


    @Inject
    private RegistrationSessionBean registrationSessionBean;

    private User registeredUser;
    private String registerResult;
    private List<String> roles;

    public RegisterBean() {
        this.registeredUser = new User();
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

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void saveUser()
    {
        System.out.println(registeredUser.getUsername());
        System.out.println(registeredUser.getPassword());
        System.out.println(registeredUser.getEmail());
        System.out.println(registeredUser.getRole());
        registeredUser.setBalance(100.0);
        registrationSessionBean.setUser(registeredUser);
        registrationSessionBean.addUserToDatabase();

    }
}
