package sad.teamone.service;

import sad.teamone.entity.JobApplied;
import sad.teamone.entity.Skill;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface JobAppliedService {
    Boolean insert(JobApplied jobApplied);
    Boolean update(JobApplied jobApplied);
    Boolean delete(JobApplied jobApplied);
    Boolean remove(int i);
    JobApplied find(int id);
}
