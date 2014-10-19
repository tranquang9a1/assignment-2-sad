package sad.teamone.dao.impl;

import sad.teamone.dao.BaseDAO;

import javax.persistence.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by QuangTV on 10/19/2014.
 */
public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
    protected EntityManager em;

    private Class<T> entityClass;

    protected BaseDAOImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
        this.em.setFlushMode(FlushModeType.COMMIT);
    }

    @Override
    public T insert(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        em.merge(entity);
        return entity;
    }

    @Override
    public T delete(Integer key) {
        T entity = find(key);
        if (entity != null) {
            em.remove(entity);
        }
        return entity;
    }

    @Override
    public T delete(T entity) {
        if (entity != null) {
            em.remove(entity);
        }
        return entity;
    }

    @Override
    public T find(Integer key) {
        T result = em.find(entityClass, key);
        return result;
    }

    @Override
    public void flush()  {
        em.flush();
    }
}
