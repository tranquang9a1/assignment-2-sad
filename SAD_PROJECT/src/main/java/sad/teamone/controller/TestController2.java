package sad.teamone.controller;

import sad.teamone.common.annotation.Controller;
import sad.teamone.common.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tuyen on 10/17/2014.
 */
@Controller
@RequestMapping(url = "/test")
public class TestController2 {
    @RequestMapping(url = "/tuyen")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print("Test Tuyen");
        writer.close();
    }
}
