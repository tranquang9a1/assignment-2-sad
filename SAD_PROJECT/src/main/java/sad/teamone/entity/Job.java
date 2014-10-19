package sad.teamone.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name ="tbl_job")
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "jobID")
    private int jobID;

    @Column(name = "jobName")
    private String jobName;

    @Column(name = "jobDescription") // Chi tiet cong viec
    private String jobDescription;

    @Column(name = "jobRequirement") // Yeu cau cong viec
    private String jobRequirement;

    @Column(name = "jobAddress") // Noi lam viec
    private String address;

    @Column(name = "jobSalary") // Tien luong du kien
    private int salary;

    @Column(name = "numberUser")
    private int numberUser; // So luong nguoi can tuyen.

    @Column(name = "categoryID")
    private int categoryID;

    @Column(name = "status")
    private boolean status;

    @Column(name = "userID")
    private int userID;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "create_date")
    private Date create_date;

    public Job(String jobName, String jobDescription, String jobRequirement, String address, int salary, int numberUser,
               int categoryID, boolean status, int userID, Date deadline, Date create_date) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobRequirement = jobRequirement;
        this.address = address;
        this.salary = salary;
        this.numberUser = numberUser;
        this.categoryID = categoryID;
        this.status = status;
        this.userID = userID;
        this.deadline = deadline;
        this.create_date = create_date;
    }

    public Job() {
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
}
