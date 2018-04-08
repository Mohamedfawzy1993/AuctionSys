package controller;


import model.dao.UserDao;
import model.dto.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
@LocalBean
public class RegistrationSessionBean implements Serializable {

    @Inject
    private UserDao userDao;
    private User user;

    public RegistrationSessionBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isExist(String email) {
        User user = userDao.getUserByEmail(email);
        return user != null;
    }

    public boolean addUserToDatabase() {
        boolean result = false;
        if (user != null) {
            result = isExist(user.getEmail());
            if (result) {
                result = false;
            } else {
                userDao.create(user);
                result = true;
            }
        }
        return result;
    }


}
