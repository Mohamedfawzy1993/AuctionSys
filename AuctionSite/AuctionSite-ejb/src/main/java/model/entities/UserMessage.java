package model.entities;

import javax.persistence.*;

@Entity
@Table(name = "userMessage", schema = "auctionSys")
public class UserMessage {
    private int id;
    private String message;
    private Users user;
    private boolean active;

    public UserMessage(String message, Users user , boolean active) {
        this.message = message;
        this.user = user;
        this.active = active;
    }

    public UserMessage() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "user_id", nullable = false)
    public Users getUser() {
        return user;
    }

    public void setUser(Users usersByUserUserId) {
        this.user = usersByUserUserId;
    }

    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMessage that = (UserMessage) o;

        if (id != that.id) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
