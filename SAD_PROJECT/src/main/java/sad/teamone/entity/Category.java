package sad.teamone.entity;

import javax.persistence.*;

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
}
