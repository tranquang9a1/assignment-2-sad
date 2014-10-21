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
    public T insert(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public T update(T entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public T delete(Integer key) {
        EntityManager em = emf.createEntityManager();
        T entity = null;
        try {
            em.getTransaction().begin();
            entity = find(key);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public T delete(T entity) {
        EntityManager em = emf.createEntityManager();
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
        } finally {
            em.close();
        }

        return entity;
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
            Query query = em.createQuery("Select e From " + entityClass.getSimpleName() + " e");
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
