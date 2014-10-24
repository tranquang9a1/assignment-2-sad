package sad.teamone.service;

import sad.teamone.entity.User;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface UserService {
    Boolean insert(User user);
    Boolean update(User user);
    Boolean delete(User user);
    Boolean remove(int i);
    User find(int id);
    List findByName(String name);

    User checkLogin(String username, String password);
    List findToday();
    List findAll();
    Boolean deleteByID(Integer id);
    User findByID(int ID);
}
