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
    private int categoryID;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_job_category",
            joinColumns =
                @JoinColumn(name = "categoryID", referencedColumnName = "categoryID"),
            inverseJoinColumns =
                @JoinColumn(name = "jobID", referencedColumnName = "jobID")
    )
    private List<Job> jobs = new ArrayList<Job>();

    @Column(name = "categoryName")
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
