package sad.teamone.controller;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;
import sad.teamone.common.constant.RequestMethod;
import sad.teamone.entity.Comment;
import sad.teamone.service.CommentService;
import sad.teamone.service.JobService;
import sad.teamone.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by QuangTV on 10/23/2014.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @RequestMapping(url = "/comment.do", method = RequestMethod.POST)
    public void doComment(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String idtopic = request.getParameter("idtopic");
        String id = request.getParameter("userID");
        String content = request.getParameter("content");
        Comment comment = new Comment(content, new Date(System.currentTimeMillis()),
                jobService.find(Integer.parseInt(idtopic)), userService.find(Integer.parseInt(id)));

        commentService.insert(comment);
        response.sendRedirect("/job.do?id="+idtopic);
    }
}
