package sad.teamone.common.listener;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sad.teamone.common.action.Action;
import sad.teamone.common.action.ActionBean;
import sad.teamone.common.annotation.*;
import sad.teamone.common.bean.BeanDefinition;
import sad.teamone.common.constant.RequestMethod;
import sad.teamone.common.util.ActionMap;
import sad.teamone.common.util.ProjectReflections;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Tuyen on 10/10/2014.
 */
@WebListener
public class ContextListener implements ServletContextListener {

    protected static final Logger LOG = LoggerFactory.getLogger(ContextListener.class);

    protected static final Reflections reflections = ProjectReflections.INSTANCE.getReflections();

    protected static final List<BeanDefinition> beanList = new ArrayList<BeanDefinition>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            LOG.info("Initialize context!!");

            // Init config
            scanAndInitConfiguration();

            // Do autowired for beans
            doAutowiredForBeans();

            // Init action map
            initializeActionMap();

            ActionMap.INSTANCE.viewAllMappedUrls();

        } catch (Exception ex) {
            LOG.error("There is an error occurred when " +
                    "initializing ActionMap. Stack trace: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        closeEntityManagerFactory();
    }

    /****************************************************************/
    /****************************************************************/
    /******************      Support methods     ********************/
    /****************************************************************/
    /****************************************************************/

    /**
     * This class will scan and create a map of bean in class annotated
     * by @Configuration
     */

    protected void scanAndInitConfiguration() throws InstantiationException, InvocationTargetException,
            IllegalAccessException {
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Configuration.class);

        for (Class<?> clazz : classes) {
            Object configObject = clazz.newInstance();
            Method[] methods = clazz.getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Bean.class)) {
                    Bean annotationBean = method.getAnnotation(Bean.class);
                    String name = annotationBean.name();
                    Object reference = method.invoke(configObject);

                    BeanDefinition bean = new BeanDefinition(name, reference);
                    beanList.add(bean);
                }
            }
        }
    }

    /**
     *
     */
    protected void doAutowiredForBeans() throws IllegalAccessException {
        for (BeanDefinition bean : beanList) {
            doAutowired(bean.getReference());
        }
    }

    protected void doAutowired(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Autowired.class)) {
                Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
                String id = autowiredAnnotation.id();

                Class<?> fieldType = field.getType();
                for (BeanDefinition bean : beanList) {
                    Object ref = bean.getReference();
                    if (!"".equals(id)) {
                        if (bean.getName().equals(id)) {
                            if (fieldType.isInstance(ref)) {
                                field.set(obj, ref);
                                break;
                            }
                        }
                    }

                    if (fieldType.isInstance(ref)) {
                        field.set(obj, ref);
                        break;
                    }
                }
            }
        }
    }


    /**
     *  This method will initialize ActionMap
     *  @throws InstantiationException, IllegalAccessException
     */
    protected void initializeActionMap() throws InstantiationException, IllegalAccessException {
        // 1. Scan all the class annotated by Controller annotation
        // 2. Get the url mapping value if there is.
        // 3. Init the invoke controller object
        // 4. Get all methods
        // 5. Init ActionBean object with the method and the invoke controller
        // 6. Get the url and method of the method
        // 7. Put the ActionBean object into the ActionMap with the mapping url


        // 1. Scan all the class annotated by Controller annotation
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Controller.class);

        for (Class clazz : classes) {
            String classUrl = "";

            //  2. Get the url mapping value if there is.
            if (clazz.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping mapping = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
                classUrl += mapping.url()[0];
            }

            // 3. Init the invoke controller object
            Object invokedObj = clazz.newInstance();

            // 4. Get all methods
            Method[] methods = clazz.getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    // 5. Init ActionBean object with the method and the invoke controller
                    Action actionBean = new ActionBean(invokedObj, method);

                    RequestMapping mapping = (RequestMapping)method.getAnnotation(RequestMapping.class);
                    String[] methodUrls = mapping.url();
                    RequestMethod[] requestMethods = mapping.method();

                    // 6. Get the url and method of the method
                    for (String methodUrl : methodUrls) {
                        for (RequestMethod requestMethod : requestMethods) {
                            String url = classUrl + methodUrl + "/" + requestMethod.getValue();

                            // Do autowired for controller
                            doAutowired(invokedObj);

                            // 7. Put the ActionBean object into the ActionMap with the mapping url
                            ActionMap.INSTANCE.addAction(url, actionBean);
                        }
                    }
                }
            }
        }
    }

    /**
     * This method will find the EntityManagerFactory in beanList
     * @return EntityManagerFactory
     */
    protected EntityManagerFactory findEntityManagerFactory() {
        for (BeanDefinition beanDefinition : beanList) {
            Object obj = beanDefinition.getReference();
            if (obj instanceof EntityManagerFactory) {
                return (EntityManagerFactory) obj;
            }
        }
        return null;
    }

    /**
     * This method will close the EntityManagerFactory
     */
    protected void closeEntityManagerFactory() {
        EntityManagerFactory emf = findEntityManagerFactory();
        if (emf != null) {
            emf.close();
        }
    }


}
