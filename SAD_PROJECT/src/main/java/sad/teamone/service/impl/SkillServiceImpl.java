package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.SkillDAO;
import sad.teamone.entity.Skill;
import sad.teamone.service.SkillService;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDAO skillDAO;

    @Override
    public Skill insert(Skill skill) {
        return (Skill) skillDAO.insert(skill);
    }

    @Override
    public Skill update(Skill skill) {
        return (Skill)skillDAO.update(skill);
    }

    @Override
    public Skill delete(Skill skill) {
        return (Skill) skillDAO.delete(skill);
    }

    @Override
    public Skill remove(int id) {
        return (Skill) skillDAO.delete(id);
    }

    @Override
    public Skill find(int id) {
        return (Skill) skillDAO.find(id);
    }
}
