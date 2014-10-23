package sad.teamone.controller;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;
import sad.teamone.common.annotation.ResponeBody;
import sad.teamone.common.constant.RequestMethod;
import sad.teamone.entity.Comment;
import sad.teamone.entity.Job;
import sad.teamone.entity.User;
import sad.teamone.service.CommentService;
import sad.teamone.service.JobService;
import sad.teamone.service.UserService;

import javax.annotation.RegEx;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by QuanVMH on 10/22/2014.
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(url = "/admincp.do")
    public String admin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        // If wrong username and password
        if (user == null || !user.getIsAdmin()) {
            return "WEB-INF/admin/login.jsp";
        }
        return "WEB-INF/admin/index.jsp";
    }

    @RequestMapping(url = "/admincp.do", method = RequestMethod.POST)
    public String adminlogin(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        User user = userService.checkLogin(username, password);

        // If wrong username and password
        if (user == null) {
            return "WEB-INF/admin/login.jsp";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        if (!user.getIsAdmin()) {
            return "index.jsp";
        }

        List<Job> listJob = jobService.findToday();
        List<User> listUser = userService.findToday();
        List<Comment> listComment = commentService.findToday();
        session.setAttribute("countJob", listJob.size());
        session.setAttribute("countUser", listUser.size());
        session.setAttribute("countComment", listComment.size());
        session.setAttribute("Job", listJob);
        session.setAttribute("User", listUser);
        session.setAttribute("Comment", listComment);



        return "WEB-INF/admin/index.jsp";
    }

    @RequestMapping(url = "/commentjson.do")
    @ResponeBody
    public Object json(HttpServletRequest request, HttpServletResponse response) {
        List<Comment> listComment = commentService.findToday();
        return listComment;
    }

    @RequestMapping(url = "/admincomment.do")
    public String comment(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/admin/comment.jsp";
    }

    @RequestMapping(url = "/adminuser.do")
    public String user(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/admin/user.jsp";
    }

    @RequestMapping(url = "/adminjob.do")
    public String job(HttpServletRequest request, HttpServletResponse response) {
        return "WEB-INF/admin/job.jsp";
    }

}
