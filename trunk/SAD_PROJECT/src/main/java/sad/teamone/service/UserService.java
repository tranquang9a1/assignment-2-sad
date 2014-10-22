package sad.teamone.service;

import sad.teamone.entity.User;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface UserService {
    Boolean insert(User user);
    Boolean update(User user);
    Boolean delete(User user);
    Boolean remove(int i);
    User find(int id);

    User checkLogin(String username, String password);
}
