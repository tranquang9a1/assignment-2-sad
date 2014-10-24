package sad.teamone.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userID")
    private Integer userID;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age;
    @Column(name = "description")
    private String description;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "sex")
    private Boolean sex;
    @Column(name = "address")
    private String address;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @Column(name = "create_date")
    private Date create_date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_user_skill",
            joinColumns =
                    @JoinColumn(name = "userID", referencedColumnName = "userID"),
            inverseJoinColumns =
                    @JoinColumn(name = "skillID", referencedColumnName = "skillID")
    )
    private List<Skill> skills = new ArrayList<Skill>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JobApplied> jobApplieds = new ArrayList<JobApplied>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private List<Notify> notifies = new ArrayList<Notify>();


    // Constructors
    public User() {
    }
    public  User(String username, String password, String email, Date create_date){
        this.username=username;
        this.password=password;
        this.email=email;
        this.create_date=create_date;
        this.isAdmin=false;
        this.sex=true;
    }
   // Getters and setters

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<JobApplied> getJobApplieds() {
        return jobApplieds;
    }

    public void setJobApplieds(List<JobApplied> jobApplieds) {
        this.jobApplieds = jobApplieds;
    }

    public List<Notify> getNotifies() {
        return notifies;
    }

    public void setNotifies(List<Notify> notifies) {
        this.notifies = notifies;
    }
}
