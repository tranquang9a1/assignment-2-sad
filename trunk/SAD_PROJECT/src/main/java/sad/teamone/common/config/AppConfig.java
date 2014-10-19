package sad.teamone.common.config;

import org.hibernate.jpa.AvailableSettings;
import org.reflections.Reflections;
import sad.teamone.common.annotation.Bean;
import sad.teamone.common.annotation.Configuration;
import sad.teamone.dao.*;
import sad.teamone.dao.impl.*;
import sad.teamone.service.*;
import sad.teamone.service.impl.*;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

/**
 * Created by Tuyen on 10/19/2014.
 */
@Configuration
public class AppConfig {

    @Bean
    public EntityManagerFactory getEntityManagerFactory() {
        // Scan all entity class
        List<Class> entityClasses = getScannedEntityClass();
        Properties additionProperties = new Properties();
        additionProperties.put(AvailableSettings.LOADED_CLASSES, entityClasses);

        // Create entity manager factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit", additionProperties);
        return emf;
    }

    //Service Bean
    @Bean(name = "service1")
    public TestService getTestService() {
        return new TestService1();
    }

    @Bean(name = "service2")
    public TestService getTestService2() {
        return new TestService2();
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryServiceImpl();
    }

    @Bean
    public CommentService commentService() {
        return new CommentServiceImpl();
    }

    @Bean
    public JobService jobService() {
        return new JobServiceImpl();
    }

    @Bean
    public NotifyService notifyService() {
        return new NotifyServiceImpl();
    }

    @Bean
    public SkillService skillService() {
        return new SkillServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    // DAO Bean

    @Bean
    public TestDAO getTestDAO() {
        return new HelloDAO();
    }

    @Bean
    public CategoryDAO categoryDAO() {
        return  new CategoryDAOImpl();
    }

    @Bean
    public CommentDAO commentDAO() {
        return new CommentDAOImpl();
    }

    @Bean
    public JobDAO jobDAO() {
        return new JobDAOImpl();
    }

    @Bean
    public NotifyDAO notifyDAO() {
        return new NotifyDAOImpl();
    }

    @Bean
    public SkillDAO skillDAO() {
        return new SkillDAOImpl();
    }

    @Bean UserDAO userDAO() {
        return new UserDAOImpl();
    }

    /*********************************************************/
    /*************      support methods  *********************/
    /*********************************************************/
    private List<Class> getScannedEntityClass() {
        Reflections reflections = new Reflections("sad.teamone");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
        List<Class> result = new ArrayList<Class>();
        result.addAll(classes);
        return result;
    }

}
