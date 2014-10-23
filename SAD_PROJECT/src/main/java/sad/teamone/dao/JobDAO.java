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
    List findByLocation(String address);
    List findByCategory(int categoryID);
    List findByCategoryAndLocation(int categoryID, String address);
    List findByCategoryAndSalary(int categoryID, int min, int max);
    List findByLocationAndSalary(String address, int min, int max);
    List findByCategoryAndLocationAndSalary(int categoryID, String address, int min, int max);
    List findToday();
    List findLimit();
}
