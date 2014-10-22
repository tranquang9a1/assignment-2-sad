package sad.teamone.controller;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;
import sad.teamone.common.constant.RequestMethod;
import sad.teamone.entity.User;
import sad.teamone.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by QuangTV on 10/21/2014.
 */
@Controller
public class UserController {

    @Autowired(id = "userService")
    private UserService userService;


    @RequestMapping(url = "/signin.do")
    public String signinPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return "WEB-INF/signin.jsp";
    }

    @RequestMapping(url = "/signup.do")
    public String signupPage(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/signup.jsp";
    }

    @RequestMapping(url = "/login.do", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.checkLogin(username, password);

        // If wrong username and password
        if (user == null) {
            return "WEB-INF/signin.jsp";
        }

        // Create new session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "index.jsp";
    }

    @RequestMapping(url = "/logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "index.jsp";
    }

    @RequestMapping(url = "/signUp.do", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String email = request.getParameter("txtEmail");
        User user = new User(username,password,email);
        Boolean result = userService.insert(user);

        // signUp fail
        if (!result) {
            request.setAttribute("ERROR", true);
            return "WEB-INF/signup.jsp";
        }

        // Create new session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "index.jsp";
    }
}
