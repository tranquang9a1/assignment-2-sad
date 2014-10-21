package sad.teamone.common.config;

import org.hibernate.jpa.AvailableSettings;
import org.reflections.Reflections;
import sad.teamone.common.annotation.Bean;
import sad.teamone.common.annotation.Configuration;
import sad.teamone.common.util.ProjectReflections;
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
    @Bean(name = "categoryService")
    public CategoryService categoryService() {
        return new CategoryServiceImpl();
    }

    @Bean(name = "commentService")
    public CommentService commentService() {
        return new CommentServiceImpl();
    }

    @Bean(name = "jobService")
    public JobService jobService() {
        return new JobServiceImpl();
    }

    @Bean(name = "notifyService")
    public NotifyService notifyService() {
        return new NotifyServiceImpl();
    }

    @Bean(name = "skillService")
    public SkillService skillService() {
        return new SkillServiceImpl();
    }

    @Bean(name = "userService")
    public UserService userService() {
        return new UserServiceImpl();
    }

    // DAO Bean
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


    @Bean(name = "userDAO")
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    /*********************************************************/
    /*************      support methods  *********************/
    /*********************************************************/
    private List<Class> getScannedEntityClass() {
        Reflections reflections = ProjectReflections.INSTANCE.getReflections();
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);
        List<Class> result = new ArrayList<Class>();
        result.addAll(classes);
        return result;
    }
}
