package sad.teamone.service;

import sad.teamone.entity.Skill;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface SkillService {
    Skill insert(Skill skill);
    Skill update(Skill skill);
    Skill delete(Skill skill);
    Skill remove(int i);
    Skill find(int id);
}
