package sad.teamone.service;

import sad.teamone.entity.Job;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface JobService {

    Job insert(Job job);
    Job update(Job job);
    Job delete(Job job);
    Job remove(int id);
    Job find(int id);
    List findAll();
    List findByName(String jobName);
    List findBySalary(int min, int max);
    List findByStatus(Boolean status);
    List findUserId(int userID);
}
