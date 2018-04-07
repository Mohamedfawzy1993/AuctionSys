/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = ?")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = ?")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = ?")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = ?")
    , @NamedQuery(name = "User.findByBalance", query = "SELECT u FROM User u WHERE u.balance = ?")
    , @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = ?")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userUserId")
    private List<UserSellProduct> userSellProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userUserId")
    private List<UserBidProduct> userBidProductList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String username, String email, String password, double balance, String role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }
    public User( String username, String email, String password, double balance, String role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.User[ userId=" + userId + " ]";
    }
    
}
