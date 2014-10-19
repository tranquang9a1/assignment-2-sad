package sad.teamone.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Entity
@Table(name = "tbl_notify")
public class Notify {

    @Id
    @GeneratedValue
    @Column(name = "notifyID")
    private int notifyID;

    @Column(name = "content")
    private String content; //Noi dung se notify

    @Column(name = "userID")
    private int userID;

    @Column(name = "status")
    private boolean status;

    @Column(name = "create_date")
    private Date create_date;
}
