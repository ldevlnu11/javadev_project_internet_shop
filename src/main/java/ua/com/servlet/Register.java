package ua.com.servlet;

import ua.com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by devnull on 09.10.16.
 */
public class Register extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User user = new User(req.getParameter("reg_fname"), req.getParameter("reg_sname"),
                req.getParameter("reg_login"), req.getParameter("reg_email"), req.getParameter("reg_phone"), req.getParameter("reg_password"));
    }
}
