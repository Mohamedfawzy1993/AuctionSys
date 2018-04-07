package web;


import controller.beans.TestBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.dto.User;

@ManagedBean(name = "bean")
@SessionScoped
public class userManagedBean {

    @EJB
    private TestBean testBean;



    private String username;
  


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
