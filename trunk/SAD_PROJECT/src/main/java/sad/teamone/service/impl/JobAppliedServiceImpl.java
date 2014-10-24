package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.JobAppliedDAO;
import sad.teamone.dao.SkillDAO;
import sad.teamone.entity.JobApplied;
import sad.teamone.entity.Skill;
import sad.teamone.service.JobAppliedService;
import sad.teamone.service.SkillService;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class JobAppliedServiceImpl implements JobAppliedService {

    @Autowired
    private JobAppliedDAO jobAppliedDAO;

    @Override
    public Boolean insert(JobApplied jobApplied) {
        return  jobAppliedDAO.insert(jobApplied);
    }

    @Override
    public Boolean update(JobApplied jobApplied) {
        return jobAppliedDAO.update(jobApplied);
    }

    @Override
    public Boolean delete(JobApplied jobApplied) {
        return  jobAppliedDAO.delete(jobApplied);
    }

    @Override
    public Boolean remove(int id) {
        return jobAppliedDAO.delete(id);
    }

    @Override
    public JobApplied find(int id) {
        return (JobApplied) jobAppliedDAO.find(id);
    }
}
