package sad.teamone.dao.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.BaseDAO;

import javax.persistence.*;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {
    @Autowired
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

    private Class<T> entityClass;

    protected BaseDAOImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }


    @Override
    public Boolean insert(T entity) {
        EntityManager em = emf.createEntityManager();
        Boolean result = true;
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            result = false;
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public Boolean update(T entity) {
        EntityManager em = emf.createEntityManager();
        Boolean result = true;
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            result = false;
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public Boolean delete(Integer key) {
        EntityManager em = emf.createEntityManager();
        Boolean result = true;
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass,key);
            if (entity != null) {
                em.remove(entity);
            } else {
                result = false;
            }
            em.flush();
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            result = false;
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public Boolean delete(T entity) {
        EntityManager em = emf.createEntityManager();
        Boolean result = true;
        try {
            em.getTransaction().begin();
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            result = false;
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public T find(int key) {
        EntityManager em = emf.createEntityManager();
        T result = null;
        try {
            em.getTransaction().begin();
            result = em.find(entityClass, key);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public List findAll() {
        EntityManager em = emf.createEntityManager();
        List result = new ArrayList<T>();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select e From " + entityClass.getSimpleName() + " e order by e.create_date desc" );
            result = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public void flush() {
//        em.flush();
    }
}
