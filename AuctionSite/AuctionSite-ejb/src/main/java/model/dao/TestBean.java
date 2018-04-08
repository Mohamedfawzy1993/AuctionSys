package model.dao;

import model.dto.User;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Stateless(name = "ConvertCurrencyEJB")
@Transactional
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

        User user = new User( "Mohamedeee" , "em@em.ed" , "e" , 2222.2 , "dd");
        em.persist(user);

        return dollar.multiply(YEN_RATE).setScale(2 , BigDecimal.ROUND_UP);

    }

    public User getUser()
    {
        System.out.println("Em is "+(em ==  null));
        User userList = em.find(User.class , 1);
        System.out.println("Query Done");
        return userList;
    }

}
