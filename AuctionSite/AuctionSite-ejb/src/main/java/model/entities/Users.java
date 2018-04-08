package model.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Users {
    private int userId;
    private String username;
    private String email;
    private String password;
    private double balance;
    private String role;
    private Collection<Product> productsByUserId;
    private Collection<UserBidProduct> userBidProductsByUserId;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (Double.compare(users.balance, balance) != 0) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (role != null ? !role.equals(users.role) : users.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUsersUserId")
    public Collection<Product> getProductsByUserId() {
        return productsByUserId;
    }

    public void setProductsByUserId(Collection<Product> productsByUserId) {
        this.productsByUserId = productsByUserId;
    }

    @OneToMany(mappedBy = "usersByUserUserId")
    public Collection<UserBidProduct> getUserBidProductsByUserId() {
        return userBidProductsByUserId;
    }

    public void setUserBidProductsByUserId(Collection<UserBidProduct> userBidProductsByUserId) {
        this.userBidProductsByUserId = userBidProductsByUserId;
    }
}
