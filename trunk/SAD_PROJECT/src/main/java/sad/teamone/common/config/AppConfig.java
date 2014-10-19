package sad.teamone.common.config;

import org.hibernate.jpa.AvailableSettings;
import org.reflections.Reflections;
import sad.teamone.common.annotation.Bean;
import sad.teamone.common.annotation.Configuration;
import sad.teamone.dao.HelloDAO;
import sad.teamone.dao.TestDAO;
import sad.teamone.service.TestService;
import sad.teamone.service.TestService1;
import sad.teamone.service.TestService2;

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

    @Bean(name = "service1")
    public TestService getTestService() {
        return new TestService1();
    }

    @Bean(name = "service2")
    public TestService getTestService2() {
        return new TestService2();
    }

    @Bean
    public TestDAO getTestDAO() {
        return new HelloDAO();
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
