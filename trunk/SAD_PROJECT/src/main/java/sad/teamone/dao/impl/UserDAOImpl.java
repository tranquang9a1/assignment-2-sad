package sad.teamone.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sad.teamone.dao.UserDAO;
import sad.teamone.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO<User> {
    Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    @Override
    public User login(String username, String password) {
        try {
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT a FROM User a WHERE a.username = :username AND a.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            User user = (User)query.getSingleResult();
            return user;
        }catch (NoResultException ex) {
            log.info(ex.getMessage());
            return null;
        }
    }
}