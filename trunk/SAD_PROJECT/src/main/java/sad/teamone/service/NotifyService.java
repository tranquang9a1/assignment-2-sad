package sad.teamone.service;

import sad.teamone.entity.Notify;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface NotifyService {
    Notify insert(Notify notify);
    Notify update(Notify notify);
    Notify delete(Notify notify);
    Notify remove(int i);
    Notify find(int id);
}
