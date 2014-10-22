package sad.teamone.service;

import sad.teamone.entity.Skill;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface SkillService {
    Boolean insert(Skill skill);
    Boolean update(Skill skill);
    Boolean delete(Skill skill);
    Boolean remove(int i);
    Skill find(int id);
}
