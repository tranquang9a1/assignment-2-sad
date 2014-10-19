package sad.teamone.dao;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Tuyen on 10/19/2014.
 */
public class HelloDAO implements TestDAO {
    @Autowired
    EntityManagerFactory emf;

    @Override
    public String sayHello() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = new Book();
        book.setTitle("Test hello");

        em.persist(book);

        em.getTransaction().commit();
        em.close();
        return "Hello DAO!!!!";
    }
}
