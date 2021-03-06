package sad.teamone.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name ="tbl_job")
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "jobID")
    private Integer jobID;

    @Column(name = "jobName")
    private String jobName;

    @Column(name = "jobDescription") // Chi tiet cong viec
    private String jobDescription;

    @Column(name = "jobRequirement") // Yeu cau cong viec
    private String jobRequirement;

    @Column(name = "jobAddress") // Noi lam viec
    private String address;

    @Column(name = "jobSalary") // Tien luong du kien
    private Integer salary;

    @Column(name = "numberUser")
    private Integer numberUser; // So luong nguoi can tuyen.

    @Column(name = "status")
    private Boolean status;

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "username")
    private String username;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "create_date")
    private Date create_date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_job_category",
            joinColumns =
            @JoinColumn(name = "jobID", referencedColumnName = "jobID"),
            inverseJoinColumns =
            @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    )
    private List<Category> categories = new ArrayList<Category>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "jobID")
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "job",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JobApplied> jobApplieds = new ArrayList<JobApplied>();

    // Constructors
    public Job() {
    }

    public Job(String jobName, String jobDescription, String jobRequirement, String address, Integer salary, Integer numberUser, Date deadline, Date create_date, Integer userID, String username, List<Category> categories, Boolean status) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobRequirement = jobRequirement;
        this.address = address;
        this.salary = salary;
        this.numberUser = numberUser;
        this.deadline = deadline;
        this.create_date = create_date;
        this.userID = userID;
        this.username = username;
        this.categories = categories;
        this.status = status;
    }

    // Getters and setters
    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setJobRequirement(String jobRequirement) {
        this.jobRequirement = jobRequirement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(Integer numberUser) {
        this.numberUser = numberUser;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<JobApplied> getJobApplieds() {
        return jobApplieds;
    }

    public void setJobApplieds(List<JobApplied> jobApplieds) {
        this.jobApplieds = jobApplieds;
    }
}
