package sad.teamone.service;

import sad.teamone.entity.Notify;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface NotifyService {
    Boolean insert(Notify notify);
    Boolean update(Notify notify);
    Boolean delete(Notify notify);
    Boolean remove(int i);
    Notify find(int id);
}
