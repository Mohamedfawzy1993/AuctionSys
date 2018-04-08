package controller;


import model.dao.UserDao;
import model.entities.Users;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
@LocalBean
public class LoginSessionBean implements Serializable {

    @Inject
    private UserDao userDao;

    public LoginSessionBean() {
    }

    public Users getUserData(String email) {
        return userDao.getUserByEmail(email);
    }

    public Users VerifyUser(String email, String password) {
        email = email.trim();
        Users Users = getUserData(email);
        if (Users != null)
        {
            boolean result = Users.getPassword().equals(password);
            Users = result ? Users : null;
        }
        return Users;
    }
}
