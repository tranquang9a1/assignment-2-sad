package sad.teamone.dao;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface JobDAO<Job> extends BaseDAO<Job>{
    List findByName(String jobName);
    List findBySalary(int min, int max);
    List findByStatus(Boolean status);
    List findUserId(int userID);
    List findToday();
}
