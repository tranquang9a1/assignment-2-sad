package sad.teamone.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name = "tbl_skill")
public class Skill {

    @Id
    @GeneratedValue
    @Column(name = "skillID")
    private Integer skillID;

    @Column(name = "skillName")
    private String skillName;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<User>();

    public Skill() {
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public Integer getSkillID() {
        return skillID;
    }

    public void setSkillID(Integer skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
