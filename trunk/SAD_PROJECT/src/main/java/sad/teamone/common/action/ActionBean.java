package sad.teamone.common.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Tuyen on 10/17/2014.
 */
public class ActionBean implements Action {

    static final Logger LOG = LoggerFactory.getLogger(ActionBean.class);

    // Attributes
    private Object object;
    private Method method;

    // Constructors
    public ActionBean() {
    }

    public ActionBean(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            method.invoke(object, request, response);
        } catch (Exception ex) {
            LOG.error("Error when invoking request resolver method. Stack trace: ", ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Getters and setters
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
