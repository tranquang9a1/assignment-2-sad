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
    private int userID;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;
    @Column(name = "description")
    private String description;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "sex")
    private boolean sex;
    @Column(name = "address")
    private String address;

    @Column(name = "isAdmin")
    private boolean isAdmin;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private List<JobApplied> jobApplieds = new ArrayList<JobApplied>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private List<Notify> notifies = new ArrayList<Notify>();


    // Constructors
    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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
}
