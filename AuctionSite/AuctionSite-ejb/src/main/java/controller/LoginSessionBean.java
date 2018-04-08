package controller;


import model.dao.UserDao;
import model.dto.User;

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

    public User getUserData(String email) {
        return userDao.getUserByEmail(email);
    }

    public User VerifyUser(String email, String password) {
        email = email.trim();
        User user = getUserData(email);
        if (user != null)
        {
            boolean result = user.getPassword().equals(password);
            user = result ? user : null;
        }
        return user;
    }
}
