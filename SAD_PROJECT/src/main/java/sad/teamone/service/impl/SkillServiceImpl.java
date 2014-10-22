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
    public Boolean insert(Skill skill) {
        return  skillDAO.insert(skill);
    }

    @Override
    public Boolean update(Skill skill) {
        return skillDAO.update(skill);
    }

    @Override
    public Boolean delete(Skill skill) {
        return  skillDAO.delete(skill);
    }

    @Override
    public Boolean remove(int id) {
        return skillDAO.delete(id);
    }

    @Override
    public Skill find(int id) {
        return (Skill) skillDAO.find(id);
    }
}
