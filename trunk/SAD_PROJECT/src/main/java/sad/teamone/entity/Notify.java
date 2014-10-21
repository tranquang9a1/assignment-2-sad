package sad.teamone.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name = "tbl_notify")
public class Notify {

    @Id
    @GeneratedValue
    @Column(name = "notifyID")
    private Integer notifyID;

    @Column(name = "content")
    private String content; //Noi dung se notify

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_date")
    private Date create_date;

    @ManyToOne
    @JoinColumn(nullable=false, updatable=false)
    private User user;

    // Constructors
    public Notify() {
    }

    // Getters and setters
    public Integer getNotifyID() {
        return notifyID;
    }

    public void setNotifyID(Integer notifyID) {
        this.notifyID = notifyID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
