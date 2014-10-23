package sad.teamone.dao;

import sad.teamone.dao.impl.BaseDAOImpl;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface CommentDAO<Comment> extends BaseDAO<Comment> {
    List findByJobId(int jobID);
    List findToday();
}
