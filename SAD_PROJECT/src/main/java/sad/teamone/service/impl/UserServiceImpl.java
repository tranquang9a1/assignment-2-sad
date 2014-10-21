package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Service;
import sad.teamone.dao.UserDAO;
import sad.teamone.entity.User;
import sad.teamone.service.UserService;

/**
 * Created by QuangTV on 10/19/2014.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User insert(User user) {
        return (User) userDAO.insert(user);
    }

    @Override
    public User update(User user) {
        return (User) userDAO.update(user);
    }

    @Override
    public User delete(User user) {
        return (User) userDAO.delete(user);
    }

    @Override
    public User remove(int id) {
        return (User) userDAO.delete(id);
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
}
