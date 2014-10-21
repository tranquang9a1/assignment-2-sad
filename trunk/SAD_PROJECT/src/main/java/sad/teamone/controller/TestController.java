package sad.teamone.controller;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;
import sad.teamone.common.constant.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tuyen on 10/17/2014.
 */
@Controller
public class TestController {


    @RequestMapping(url = "/hello")
    public void test2(HttpServletRequest req, HttpServletResponse res) throws IOException{
        PrintWriter writer = res.getWriter();
        writer.print("Hello!!");
        writer.close();
    }
}
