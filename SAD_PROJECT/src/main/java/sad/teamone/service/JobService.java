package sad.teamone.service;

import sad.teamone.entity.Job;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface JobService {

    Boolean insert(Job job);
    Boolean update(Job job);
    Boolean delete(Job job);
    Boolean remove(int id);
    Job find(int id);
    List findAll();
    List findByName(String jobName);
    List findBySalary(int min, int max);
    List findByStatus(Boolean status);
    List findUserId(int userID);
    List findByLocation(String address);
    List findByCategory(int categoryID);
    List findByCategoryAndLocation(int categoryID, String address);
    List findByCategoryAndSalary(int categoryID, int min, int max);
    List findByLocationAndSalary(String address, int min, int max);
    List findByCategoryAndLocationAndSalary(int categoryID, String address, int min, int max);
    List findToday();
    List findLimit();
}
