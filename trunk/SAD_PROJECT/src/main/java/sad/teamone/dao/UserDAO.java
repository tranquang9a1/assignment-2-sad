package sad.teamone.dao;

import sad.teamone.entity.User;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface UserDAO<User> extends BaseDAO<User> {

    User login(String username, String password);
    List findToday();
    List<User> findAll();
    sad.teamone.entity.User findByID(int ID);
}
