package sad.teamone.entity;

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
    private int commentID;

    @Column(name = "description")
    private String description;

    @Column(name = "jobID")
    private int jobID;

    @Column(name = "userID")
    private int userID;

    @Column(name = "create_date")
    private Date create_date;

    public Comment(String description, int jobID, int userID, Date create_date) {
        this.description = description;
        this.jobID = jobID;
        this.userID = userID;
        this.create_date = create_date;
    }

    public Comment() {
    }

    public int getCommentID() {
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

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
