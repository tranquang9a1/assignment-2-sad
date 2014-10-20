package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.JobDAO;
import sad.teamone.entity.Job;
import sad.teamone.service.JobService;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDAO jobDAO;

    @Override
    public Job insert(Job job) {
        return (Job)jobDAO.insert(job);
    }

    @Override
    public Job update(Job job) {
        return (Job)jobDAO.update(job);
    }

    @Override
    public Job delete(Job job) {
        return (Job) jobDAO.delete(job);
    }

    @Override
    public Job remove(int id) {
        return (Job) jobDAO.delete(id);
    }

    @Override
    public Job find(int id) {
        return (Job) jobDAO.find(id);
    }
}