package controller.beans;

import model.dto.User;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Stateless(name = "ConvertCurrencyEJB")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TestBean {

    @PersistenceContext(unitName = "auctionJPA")
    private EntityManager em;


    private final BigDecimal YEN_RATE = new BigDecimal("83.66");
    private final BigDecimal EURO_RATE = new BigDecimal("0.0093016");

    public TestBean() { }

    public BigDecimal yenToEuro(BigDecimal yen)
    {
        return yen.multiply(EURO_RATE).setScale(2 , BigDecimal.ROUND_UP);
    }
    public BigDecimal dollarToYen(BigDecimal dollar)
    {

        User user = new User( "Mohamed" , "em@em.ed" , "e" , 2222.2 , "dd");
        em.persist(user);
//        em.flush();
//        System.out.println("User ID IS : "+user.getUserId());
        return dollar.multiply(YEN_RATE).setScale(2 , BigDecimal.ROUND_UP);

    }

    public User getUser()
    {
        List<User> userList = em.createQuery("select U from User U").getResultList();
        if(userList != null && userList.size() > 0)
        {
            return userList.get(0);
        }
        return null;
    }

}
