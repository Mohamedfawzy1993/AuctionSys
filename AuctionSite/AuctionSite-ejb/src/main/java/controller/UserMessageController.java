package controller;

import model.dao.UserMessageDao;
import model.entities.UserMessage;
import model.entities.Users;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
@LocalBean
public class UserMessageController implements Serializable {

    @Inject
    private UserMessageDao userMessageDao;


    public UserMessageController() {
    }


    public List<UserMessage> getMessagesOfUser(Users user) {

        return userMessageDao.getMessagesOfUser(user);
    }

    public void deleteMessagesOfUser(Users user) {
        userMessageDao.deleteMessagesOfUser(user);
    }

}

