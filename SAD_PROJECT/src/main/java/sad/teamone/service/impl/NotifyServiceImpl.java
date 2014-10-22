package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.NotifyDAO;
import sad.teamone.entity.Notify;
import sad.teamone.service.NotifyService;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private NotifyDAO notifyDAO;

    @Override
    public Boolean insert(Notify notify) {
        return notifyDAO.insert(notify);
    }

    @Override
    public Boolean update(Notify notify) {
        return notifyDAO.update(notify);
    }

    @Override
    public Boolean delete(Notify notify) {
        return notifyDAO.delete(notify);
    }

    @Override
    public Boolean remove(int id) {
        return notifyDAO.delete(id);
    }

    @Override
    public Notify find(int id) {
        return (Notify) notifyDAO.find(id);
    }
}
