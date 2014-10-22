package sad.teamone.dao;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface BaseDAO<T> {
    Boolean insert(T entity);

    Boolean update(T entity);

    Boolean delete(Integer key);

    Boolean delete(T entity);

    T find(int key );

    List findAll();

    void flush();
}
