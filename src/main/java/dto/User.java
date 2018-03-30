package dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Muhammed Fawzy
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByBalance", query = "SELECT u FROM User u WHERE u.balance = :balance")
    , @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "balance")
    private double balance;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserSellProduct> userSellProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserBidProduct> userBidProductList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String email, String password, double balance, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public List<UserSellProduct> getUserSellProductList() {
        return userSellProductList;
    }

    public void setUserSellProductList(List<UserSellProduct> userSellProductList) {
        this.userSellProductList = userSellProductList;
    }

    @XmlTransient
    public List<UserBidProduct> getUserBidProductList() {
        return userBidProductList;
    }

    public void setUserBidProductList(List<UserBidProduct> userBidProductList) {
        this.userBidProductList = userBidProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.User[ id=" + id + " ]";
    }
    
}
