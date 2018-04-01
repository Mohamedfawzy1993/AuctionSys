package model.facade;

import model.dao.UserDao;
import model.dto.User;

import java.util.List;

public class UserFacade {

    UserDao userDao ;
    public UserFacade()
    {
        userDao = new UserDao();
    }

    public void test()
    {
        List<User> userList = userDao.selectByNamedQuery("User.findByEmail" , "dd");
        for(User user : userList)
        {
            System.out.println(user.getUserId());
        }
    }
}
