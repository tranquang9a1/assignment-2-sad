package sad.teamone.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name = "tbl_comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "commentID")
    private Integer commentID;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private Date create_date;

    @ManyToOne
    @JoinColumn(name = "jobID", nullable = false)
    private Job job;

    @OneToOne
    @JoinColumn(name = "userID",nullable = false)
    private User user;


    public Comment() {
    }

    public Comment(String description, Date create_date, Job job, User user) {
        this.description = description;
        this.create_date = create_date;
        this.job = job;
        this.user = user;
    }

    @JsonIgnore
    public Job getJob() {
        return job;
    }

    @JsonIgnore
    public void setJob(Job job) {
        this.job = job;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
