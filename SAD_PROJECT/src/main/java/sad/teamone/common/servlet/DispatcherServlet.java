package sad.teamone.common.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sad.teamone.common.action.Action;
import sad.teamone.common.util.ActionMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tuyen on 10/10/2014.
 */
@WebServlet(name = "dispatcherServlet", urlPatterns = "/*")
public class DispatcherServlet extends HttpServlet {

    protected static final Logger LOG = LoggerFactory.getLogger(DispatcherServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String requestMethod = req.getMethod();
        String mappedUrl = uri + "/" + requestMethod;
        Action action = ActionMap.INSTANCE.getAction(mappedUrl);
        LOG.info("Request to: " + uri);

        if (action != null) {
             action.service(req, res);
        } else {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            LOG.error("Resource " +  req.getRequestURL()  +" not found.");
        }
    }
}
