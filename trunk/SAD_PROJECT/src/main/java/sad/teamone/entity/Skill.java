package sad.teamone.entity;

import javax.persistence.*;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name = "tbl_skill")
public class Skill {

    @Id
    @GeneratedValue
    @Column(name = "skillID")
    private int skillID;

    @Column(name = "skillName")
    private String skillName;

    public Skill() {
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
