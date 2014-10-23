package sad.teamone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;
import sad.teamone.common.annotation.ResponeBody;
import sad.teamone.common.constant.RequestMethod;
import sad.teamone.entity.Category;
import sad.teamone.entity.Job;
import sad.teamone.entity.Skill;
import sad.teamone.entity.User;
import sad.teamone.service.CategoryService;
import sad.teamone.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tuyen on 10/22/2014.
 */
@Controller
public class JobController {
    @Autowired(id = "jobService")
    private JobService jobService;

    @Autowired(id = "categoryService")
    private CategoryService categoryService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(url = "/addJob.do")
    public String postJobPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.setAttribute("currentURL", "WEB-INF/postJob.jsp");
            return "WEB-INF/signin.jsp";
        }
        return "WEB-INF/postJob.jsp";
    }

    @RequestMapping(url = "/postJob.do", method = RequestMethod.POST)
    public String postJob(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String jobTitle = request.getParameter("txtJobTitle");
        String numberOfEmployee = request.getParameter("sbNumber");
        String category = request.getParameter("cbbCategory");
        String salary = request.getParameter("sbSalary");
        String location = request.getParameter("cbbLocation");
        String deadline = request.getParameter("txtDeadline");
        String requirement = request.getParameter("txtRequirement");
        String description = request.getParameter("txtDescription");

        User user = (User) session.getAttribute("user");
        int tmpSalary = 0;
        int tmpNum = 0;
        Date tmpDeadline = new Date();
        List<Category> listCategory = new ArrayList<Category>();
        Category tmpCategory;
        try {
            tmpSalary = Integer.parseInt(salary);
            tmpNum = Integer.parseInt(numberOfEmployee);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tmpDeadline = sdf.parse(deadline);
            tmpCategory = categoryService.find(Integer.parseInt(category));
            listCategory.add(tmpCategory);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        Job job = new Job(jobTitle, description, requirement, location, tmpSalary, tmpNum, tmpDeadline, new Date(), user.getUserID(), listCategory, false);

        Boolean result = jobService.insert(job);
        jobService.update(job);
        if (result) {
            request.setAttribute("POST_SUCCESS", true);
            log.info("Job " + job + "is posted successfully");
        }
        session.setAttribute("user", user);
        return "index.jsp";
    }

    /**
     * This method is use for test @Response body annotation
     *
     * @return
     */
    @RequestMapping(url = "/getJobs.do")
    @ResponeBody
    public List<Job> getJobs(HttpServletRequest request, HttpServletResponse response) {
        List<Job> results = new ArrayList<Job>();
        Job job1 = new Job();
        job1.setAddress("ABC");
        job1.setCreate_date(new Date());
        job1.setJobID(5);

        Job job2 = new Job();
        job2.setAddress("DEF");
        job2.setCreate_date(new Date());
        job2.setJobID(6);

        results.add(job1);
        results.add(job2);

        return results;
    }

    @RequestMapping(url = "/search.do")
    public String doSearch(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search");
        List<Job> result = jobService.findByName(keyword);
        if (result == null) {
            return "error.jsp";
        }
        HttpSession session = request.getSession();

        request.setAttribute("LISTJOB", result);

        return "WEB-INF/searchresult.jsp";
    }

    @RequestMapping(url = "/job.do")
    public String getSingleJob(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Job job = jobService.find(Integer.parseInt(id));
        HttpSession session = request.getSession();
        session.setAttribute("SINGLEJOB", job);

        if(session.getAttribute("user") == null) {
            session.setAttribute("currentURL", "WEB-INF/job.jsp");
            return "WEB-INF/signin.jsp";
        }
        return "WEB-INF/job.jsp";
    }

    @RequestMapping(url = "/findLimitJobs.do")
    @ResponeBody
    public Object findLimit(HttpServletRequest request, HttpServletResponse response) {
        List<Job> listJob = jobService.findLimit();
        return listJob;
    }
}
