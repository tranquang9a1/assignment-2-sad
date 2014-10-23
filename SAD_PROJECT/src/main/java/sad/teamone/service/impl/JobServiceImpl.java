package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.JobDAO;
import sad.teamone.entity.Job;
import sad.teamone.service.JobService;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDAO jobDAO;

    @Override
    public Boolean insert(Job job) {
        return jobDAO.insert(job);
    }

    @Override
    public Boolean update(Job job) {
        return jobDAO.update(job);
    }

    @Override
    public Boolean delete(Job job) {
        return jobDAO.delete(job);
    }

    @Override
    public Boolean remove(int id) {
        return jobDAO.delete(id);
    }

    @Override
    public Job find(int id) {
        return (Job) jobDAO.find(id);
    }

    @Override
    public List findAll() {
        return jobDAO.findAll();
    }

    @Override
    public List findByName(String jobName) {
        return jobDAO.findByName(jobName);
    }

    @Override
    public List findBySalary(int min, int max) {
        return jobDAO.findBySalary(min, max);
    }

    @Override
    public List findByStatus(Boolean status) {
        return jobDAO.findByStatus(status);
    }

    @Override
    public List findUserId(int userID) {
        return jobDAO.findUserId(userID);
    }

    @Override
    public List findToday() {
        return jobDAO.findToday();
    }

    @Override
    public List findLimit() {
        return jobDAO.findLimit();
    }

    @Override
    public List findByLocation(String address) {
        return jobDAO.findByLocation(address);
    }

    @Override
    public List findByCategory(int categoryID) {
        return jobDAO.findByCategory(categoryID);
    }

    @Override
    public List findByCategoryAndLocation(int categoryID, String address) {
        return jobDAO.findByCategoryAndLocation(categoryID,address);
    }

    @Override
    public List findByCategoryAndSalary(int categoryID, int min, int max) {
        return jobDAO.findByCategoryAndSalary(categoryID,min,max);
    }

    @Override
    public List findByLocationAndSalary(String address, int min, int max) {
        return jobDAO.findByLocationAndSalary(address,min,max);
    }

    @Override
    public List findByCategoryAndLocationAndSalary(int categoryID, String address, int min, int max){
        return jobDAO.findByCategoryAndLocationAndSalary(categoryID,address,min,max);
    }

}
