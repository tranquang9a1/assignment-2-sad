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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    private Boolean showAll = false;
    @RequestMapping(url = "/admincp.do")
    public String admin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        // If wrong username and password
        if (user == null || !user.getIsAdmin()) {
            return "WEB-INF/admin/login.jsp";
        }
        List<Job> listJob = jobService.findToday();
        List<User> listUser = userService.findToday();
        List<Comment> listComment = commentService.findToday();
        session.setAttribute("countJob", listJob.size());
        session.setAttribute("countUser", listUser.size());
        session.setAttribute("countComment", listComment.size());
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
        HttpSession session = request.getSession();
        List listComment = commentService.findToday();
        session.setAttribute("Comment", listComment);
        return "WEB-INF/admin/comment.jsp";
    }

    @RequestMapping(url = "/adminuser.do")
    public String user(HttpServletRequest request, HttpServletResponse response) {
        List listUser = userService.findToday();
        HttpSession session = request.getSession();
        session.setAttribute("User", listUser);
        return "WEB-INF/admin/user.jsp";
    }

    @RequestMapping(url = "/adminjob.do")
    public String job(HttpServletRequest request, HttpServletResponse response) {
        List<Job> listJob= jobService.findToday();
        HttpSession session = request.getSession();
        session.setAttribute("Job", listJob);
        return "WEB-INF/admin/job.jsp";
    }

    @RequestMapping(url = "/approve.do")
    public String approveJob(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Integer index = Integer.valueOf(request.getParameter("index"));

        List<Job> listJob = (List<Job>) session.getAttribute("Job");
        listJob.get(index).setStatus(true);

        session.setAttribute("Job", listJob);

        return "job.jsp";

    }

    @RequestMapping(url = "/listAllUser.do")
    public String showAllUser(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session = request.getSession();
        List listAllUser = userService.findAll();
        session.setAttribute("User", listAllUser);
        showAll = true;
        return "WEB-INF/admin/user.jsp";

    }

    @RequestMapping(url="/listAllComment.do")
    public String showAllComment(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List listComment = commentService.findAll();
        session.setAttribute("Comment",listComment);
        return "WEB-INF/admin/comment.jsp";
    }

    @RequestMapping(url="/deleteUser.do")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);
        User user = userService.find(id);
        Boolean result = userService.remove(id);
        if(result) {
           response.sendRedirect("adminuser.do");
        }
    }

    @RequestMapping(url = "/listAllJob.do")
    public String showAllJob(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List listAllJob = jobService.findAll();
        session.setAttribute("Job", listAllJob);
        return "WEB-INF/admin/job.jsp";
    }

    @RequestMapping(url="/deleteJob.do")
    public void deleteJob(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jobID = request.getParameter("jobID");
        int id = Integer.parseInt(jobID);
        Job job = jobService.find(id);
        Boolean result = jobService.remove(id);
        if(result)
        {
            response.sendRedirect("adminjob.do");
        }
    }

    @RequestMapping(url="/deleteComment.do")
    public void deleteComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String commentID=request.getParameter("commentID");
        int id = Integer.parseInt(commentID);
        Comment comment = commentService.find(id);
        Boolean result = commentService.remove(id);
        if(result){
            response.sendRedirect("admincomment.do");
        }
    }

    @RequestMapping(url="/changeStatus.do")
    public void changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jobID = request.getParameter("jobID");
        int id = Integer.parseInt(jobID);
        Job job = jobService.find(id);
        job.setStatus(true);
        jobService.update(job);
        response.sendRedirect("adminjob.do");
    }

    @RequestMapping(url="/changeRole.do")
    public void changeRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);
        User user = userService.find(id);
        user.setIsAdmin(true);
        userService.update(user);
        response.sendRedirect("adminuser.do");
    }

}
