package sad.teamone.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tuyen on 10/21/2014.
 */
@Entity
@Table(name = "tbl_job_user")
public class JobApplied {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "jobID",nullable=false, updatable=false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "userID",nullable=false, updatable=false)
    private User user;

    @Column(name = "create_date")
    private Date create_date;

    // Constructors
    public JobApplied() {
    }

    public JobApplied(Job job, User user, Date create_date) {
        this.job=job;
        this.user=user;
        this.create_date=create_date;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
