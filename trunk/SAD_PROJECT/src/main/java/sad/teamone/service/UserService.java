package sad.teamone.service;

import sad.teamone.entity.User;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface UserService {
    User insert(User user);
    User update(User user);
    User delete(User user);
    User remove(int i);
    User find(int id);

    User checkLogin(String username, String password);
}
