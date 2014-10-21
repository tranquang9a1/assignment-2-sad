package sad.teamone.dao.impl;

import sad.teamone.dao.JobDAO;
import sad.teamone.entity.Job;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class JobDAOImpl extends BaseDAOImpl<Job> implements JobDAO<Job> {
    private static final String JOB = "Job";
    private EntityManager em = emf.createEntityManager();

    @Override
    public List findByName(String jobName) {
        Query query = em.createQuery("Select e From " + JOB + " e where e.jobName like :jobName");
        query.setParameter("jobName","%" + jobName + "%");
        return query.getResultList();
    }

    @Override
    public List findByCategory(int categoryId) {
        Query query = em.createQuery("Select e From " + JOB + " e where e.categoryID =:categoryId");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List findBySalary(int min, int max) {
        Query query = em.createQuery("Select e From " + JOB + " e where (e.salary >=:minSalary and e.salary <=:maxSalary)");
        query.setParameter("minSalary", min);
        query.setParameter("maxSalary", max);
        return query.getResultList();
    }

    @Override
    public List findByStatus(Boolean status) {
        Query query = em.createQuery("Select e From " + JOB + " e where e.status =:status");
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List findUserId(int userID) {
        Query query = em.createQuery("Select e From " + JOB + " e where e.userID =:userID");
        query.setParameter("userID", userID);
        return query.getResultList();
    }

}
