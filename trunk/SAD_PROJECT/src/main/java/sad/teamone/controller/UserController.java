package sad.teamone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;
import sad.teamone.common.constant.RequestMethod;
import sad.teamone.entity.Job;
import sad.teamone.entity.Skill;
import sad.teamone.entity.User;
import sad.teamone.service.JobService;
import sad.teamone.service.SkillService;
import sad.teamone.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by QuangTV on 10/21/2014.
 */
@Controller
public class UserController {

    @Autowired(id = "userService")
    private UserService userService;

    @Autowired(id = "skillService")
    private SkillService skillService;

    @Autowired(id = "jobService")
    private JobService jobService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(url = "/signin.do")
    public String signinPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return "WEB-INF/signin.jsp";
    }

    @RequestMapping(url = "/signup.do")
    public String signupPage(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/signup.jsp";
    }

    @RequestMapping(url = "/profile.do")
    public String profilePage(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/profile.jsp";
    }

    @RequestMapping(url = "/changePassPage.do")
    public String changePassPage(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/changePass.jsp";
    }

    @RequestMapping(url = "/index.do")
    public String indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List listJob = jobService.findByStatus(true);
        request.setAttribute("LIST_JOB", listJob);
        return "index.jsp";
    }

    @RequestMapping(url = "/viewUser.do")
    public String viewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null) {
            return "WEB-INF/signin.jsp";
        }
        String userID = request.getParameter("userID");
        User user = userService.findByID(Integer.parseInt(userID));
        if (user == null) {
            List listJob = jobService.findByStatus(true);
            request.setAttribute("LIST_JOB", listJob);
            return "index.jsp";
        }
        request.setAttribute("USER_INFO", user);
        return "WEB-INF/userInfo.jsp";
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

        List listJob = jobService.findByStatus(true);
        request.setAttribute("LIST_JOB", listJob);
        if (session.getAttribute("currentURL") != null) {
            return (String) session.getAttribute("currentURL");
        }
        return "index.jsp";
    }

    @RequestMapping(url = "/logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        List listJob = jobService.findByStatus(true);
        request.setAttribute("LIST_JOB", listJob);
        return "index.jsp";
    }

    @RequestMapping(url = "/signUp.do", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String email = request.getParameter("txtEmail");
        Date create_date = new Date();
        User user = new User(username, password, email, create_date);
        Boolean result = userService.insert(user);

        // signUp fail
        if (!result) {
            request.setAttribute("ERROR", true);
            request.setAttribute("USER", user);
            return "WEB-INF/signup.jsp";
        }

        // Create new session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        log.info("Insert new user: " + user);

        List listJob = jobService.findByStatus(true);
        request.setAttribute("LIST_JOB", listJob);
        return "index.jsp";
    }

    @RequestMapping(url = "/editProfile.do", method = RequestMethod.POST)
    public String editProfile(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String img = request.getParameter("txtImg");
        String email = request.getParameter("txtEmail");
        String age = request.getParameter("sbAge");
        String sex = request.getParameter("cbbSex");
        String address = request.getParameter("txtAddress");
        String description = request.getParameter("txtDescription");
        String[] skills = request.getParameterValues("cbSkill");
        Skill tmpSkill;
        List<Skill> listSkill = new ArrayList<Skill>();
        if (skills != null) {
            if (skills.length > 0) {
                for (String skill : skills) {
                    tmpSkill = skillService.find(Integer.parseInt(skill));
                    listSkill.add(tmpSkill);
                }
            }
        }
        User user = (User) session.getAttribute("user");
        user.setAvatar(img);
        user.setEmail(email);
        user.setAddress(address);
        user.setDescription(description);
        user.setSkills(listSkill);
        user.setCreate_date(new Date());
        try {
            user.setAge(Integer.parseInt(age));
            user.setSex(Boolean.parseBoolean(sex));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        Boolean result = userService.update(user);
        if (result) {
            request.setAttribute("EDIT_SUCCESS", true);
            log.info("User " + user + "edits profile successfully");
        }
        session.setAttribute("user", user);
        return "WEB-INF/profile.jsp";
    }

    @RequestMapping(url = "/changePass.do", method = RequestMethod.POST)
    public String changePass(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String currentPass = request.getParameter("txtCurrentPass");
        String newPass = request.getParameter("txtNewPass");
        String confirmNewPass = request.getParameter("txtConfirmNewPass");
        User user = (User) session.getAttribute("user");
        if (!currentPass.equals(user.getPassword()) || !newPass.equals(confirmNewPass)) {
            request.setAttribute("ERROR", true);
            return "WEB-INF/changePass.jsp";
        }
        user.setPassword(newPass);
        Boolean result = userService.update(user);
        if (result) {
            request.setAttribute("CHANGE_SUCCESS", true);
            log.info("User " + user + "change password successfully");
        }
        session.setAttribute("user", user);
        return "WEB-INF/profile.jsp";
    }


}
