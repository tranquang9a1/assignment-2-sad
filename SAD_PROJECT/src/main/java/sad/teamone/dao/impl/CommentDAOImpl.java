package sad.teamone.dao.impl;

import sad.teamone.dao.CommentDAO;
import sad.teamone.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by QuangTV on 10/19/2014.
 */
public class CommentDAOImpl extends BaseDAOImpl<Comment> implements CommentDAO<Comment> {
    private EntityManager em = emf.createEntityManager();

    @Override
    public List findByJobId(int jobID) {
        Query query = em.createQuery("Select e From Comment e where e.jobID =:jobID");
        query.setParameter("jobID", jobID);
        return query.getResultList();
    }

    @Override
    public List findToday() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select e From Comment e where e.create_date = current_date ");
        return query.getResultList();
    }
}
