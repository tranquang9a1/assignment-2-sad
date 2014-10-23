package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Service;
import sad.teamone.dao.UserDAO;
import sad.teamone.entity.User;
import sad.teamone.service.UserService;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Boolean insert(User user) {
        return  userDAO.insert(user);
    }

    @Override
    public Boolean update(User user) {
        return  userDAO.update(user);
    }

    @Override
    public Boolean delete(User user) {
        return  userDAO.delete(user);
    }

    @Override
    public Boolean remove(int id) {
        return  userDAO.delete(id);
    }

    @Override
    public User find(int id) {
        return (User) userDAO.find(id);
    }

    @Override
    public User checkLogin(String username, String password) {
        User result = (User)userDAO.login(username, password);
        return result;
    }

    @Override
    public List findToday() {
        return userDAO.findToday();
    }

    @Override
    public List findAll() {
        return userDAO.findAll();
    }

    @Override
    public Boolean deleteByID(Integer id) {
        return  userDAO.delete(id);
    }
}
