package sad.teamone.controller;

import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by QuangTV on 10/21/2014.
 */
@Controller
public class UserController {

    @RequestMapping(url = "/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("UTF-8");
        ServletContext context=request.getServletContext();
        RequestDispatcher requestDispatcher=context.getRequestDispatcher("/index.html");
        requestDispatcher.forward(request, response);

    }
}