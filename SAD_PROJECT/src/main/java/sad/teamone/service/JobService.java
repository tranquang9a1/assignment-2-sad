package sad.teamone.service;

import sad.teamone.entity.Job;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface JobService {

    Job insert(Job job);
    Job update(Job job);
    Job delete(Job job);
    Job remove(int i);
    Job find(int id);
}
