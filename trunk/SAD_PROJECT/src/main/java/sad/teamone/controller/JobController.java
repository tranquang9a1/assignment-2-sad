package sad.teamone.controller;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;
import sad.teamone.common.annotation.ResponeBody;
import sad.teamone.entity.Job;
import sad.teamone.service.JobService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    /**
     * This method is use for test @Response body annotation
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
}
