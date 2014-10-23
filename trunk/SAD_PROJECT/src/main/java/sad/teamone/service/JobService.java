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
    List findToday();
}
