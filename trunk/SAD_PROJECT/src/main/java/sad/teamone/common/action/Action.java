package sad.teamone.common.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Tuyen on 10/16/2014.
 */
public interface Action {
    public Object service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public Method getMethod();
}
