package web;

import controller.beans.TestBean;
import model.dto.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bean")
@SessionScoped
public class userManagedBean {



    private String username;
    @EJB
    private TestBean testBean;


    public userManagedBean() {
    }

    public userManagedBean(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String setingUser()
    {
        User user = testBean.getUser();
        if(user != null)
        {
            username = user.getUsername();
        }

        return "index";
    }
}
