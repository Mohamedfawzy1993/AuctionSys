package web;


import controller.beans.UserDao;
import model.dto.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean {


    @Inject
    private UserDao userDao;

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
        userDao.create(registeredUser);
    }
}
