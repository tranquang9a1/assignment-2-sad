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
    public Notify insert(Notify notify) {
        return (Notify)notifyDAO.insert(notify);
    }

    @Override
    public Notify update(Notify notify) {
        return (Notify)notifyDAO.update(notify);
    }

    @Override
    public Notify delete(Notify notify) {
        return (Notify) notifyDAO.delete(notify);
    }

    @Override
    public Notify remove(int id) {
        return (Notify) notifyDAO.delete(id);
    }

    @Override
    public Notify find(int id) {
        return (Notify) notifyDAO.find(id);
    }
}
