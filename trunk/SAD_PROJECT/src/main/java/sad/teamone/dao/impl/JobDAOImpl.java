package sad.teamone.dao.impl;

import sad.teamone.dao.JobDAO;
import sad.teamone.entity.Job;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class JobDAOImpl extends BaseDAOImpl<Job> implements JobDAO<Job> {
    private EntityManager em = emf.createEntityManager();

    @Override
    public List findByName(String jobName) {
        Query query = em.createQuery("Select e From Job e where (e.jobName like :jobName) and e.status = true");
        query.setParameter("jobName","%" + jobName + "%");
        return query.getResultList();
    }

    @Override
    public List findBySalary(int min, int max) {
        Query query = em.createQuery("Select e From Job e where (e.salary >=:minSalary and e.salary <=:maxSalary) and e.status = true");
        query.setParameter("minSalary", min);
        query.setParameter("maxSalary", max);
        return query.getResultList();
    }

    @Override
    public List findByStatus(Boolean status) {
        Query query = em.createQuery("Select e From Job e where e.status =:status");
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List findUserId(int userID) {
        Query query = em.createQuery("Select e From Job e where e.userID =:userID and e.status = true");
        query.setParameter("userID", userID);
        return query.getResultList();
    }

    @Override
    public List findByLocation(String address) {
        Query query = em.createQuery("Select e From Job e where e.address =:address and e.status = true");
        query.setParameter("address", address);
        return query.getResultList();
    }

    @Override
    public List findByCategory(int categoryID) {
        Query query = em.createQuery("Select e From Job e where (:categoryID member of e.categories) and e.status = true");
        query.setParameter("categoryID", categoryID);
        return query.getResultList();
    }

    @Override
    public List findByCategoryAndLocation(int categoryID, String address){
        Query query = em.createQuery("Select e From Job e where (:categoryID member of e.categories) and e.address=:address and e.status = true");
        query.setParameter("categoryID", categoryID);
        query.setParameter("address",address);
        return query.getResultList();
    }

    @Override
    public List findByCategoryAndSalary(int categoryID, int minSalary, int maxSalary){
        Query query = em.createQuery("Select e From Job e where (:categoryID member of e.categories) and (e.salary >=:minSalary and e.salary <=:maxSalary) and e.status = true");
        query.setParameter("categoryID", categoryID);
        query.setParameter("minSalary",minSalary);
        query.setParameter("maxSalary",maxSalary);
        return query.getResultList();
    }

    @Override
    public List findByLocationAndSalary(String address, int minSalary, int maxSalary){
        Query query = em.createQuery("Select e From Job e where e.address =:address and (e.salary >=:minSalary and e.salary <=:maxSalary) and e.status = true");
        query.setParameter("address",address);
        query.setParameter("minSalary",minSalary);
        query.setParameter("maxSalary",maxSalary);
        return query.getResultList();
    }

    @Override
    public List findByCategoryAndLocationAndSalary(int categoryID, String address, int minSalary, int maxSalary){
        Query query = em.createQuery("Select e From Job e where (:categoryID member of e.categories) and e.address =:address and (e.salary >=:minSalary and e.salary <=:maxSalary) and e.status = true");
        query.setParameter("categoryID",categoryID);
        query.setParameter("address",address);
        query.setParameter("minSalary",minSalary);
        query.setParameter("maxSalary",maxSalary);
        return query.getResultList();
    }

    @Override
    public List findToday() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select e From Job e where e.create_date = current_date and e.status=false");
        return query.getResultList();
    }

    @Override
    public List findLimit() {
        Query query = em.createQuery("Select e From Job e order by e.create_date");
        query.setMaxResults(20);
        return query.getResultList();
    }

}
