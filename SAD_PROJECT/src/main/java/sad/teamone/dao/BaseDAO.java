package sad.teamone.dao;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface BaseDAO<T> {
    T insert(T entity);

    T update(T entity);

    T delete(Integer key);

    T delete(T entity);

    T find(int key );

    List findAll();

    void flush();
}
