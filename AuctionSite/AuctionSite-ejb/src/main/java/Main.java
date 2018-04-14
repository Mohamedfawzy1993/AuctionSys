import controller.CreateAuctionSessionBean;
import model.dao.UserDao;
import model.entities.Auction;
import model.entities.Product;
import model.entities.Users;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE MMM dd yyyy hh:mm:ss a")));
    }
}
