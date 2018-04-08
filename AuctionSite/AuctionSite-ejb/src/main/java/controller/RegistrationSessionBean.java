package controller;


import model.dao.UserDao;
import model.entities.Users;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
@LocalBean
public class RegistrationSessionBean implements Serializable {

    @Inject
    private UserDao userDao;
    private Users Users;

    public RegistrationSessionBean() {
    }

    public Users getUser() {
        return Users;
    }

    public void setUser(Users Users) {
        this.Users = Users;
    }

    public boolean isExist(String email) {
        Users Users = userDao.getUserByEmail(email);
        return Users != null;
    }

    public boolean addUserToDatabase() {
        boolean result = false;
        if (Users != null) {
            result = isExist(Users.getEmail());
            if (result) {
                result = false;
            } else {
                userDao.create(Users);
                result = true;
            }
        }
        return result;
    }


}
