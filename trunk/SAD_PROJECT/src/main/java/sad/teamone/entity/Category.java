package sad.teamone.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "categoryID")
    private Integer categoryID;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<Job>();

    @Column(name = "categoryName")
    private String categoryName;

    // Constructors
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
    }

    // Getters and setters
    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
