package ua.com.servlet;

import ua.com.entity.User;
import ua.com.function.UserFunction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by devnull on 09.10.16.
 */
public class Register extends HttpServlet{

    private UserFunction userFunction;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String firstname, secondname, login, email, phone, password;
        firstname = req.getParameter("reg_fname");
        secondname = req.getParameter("reg_sname");
        login = req.getParameter("reg_login");
        email = req.getParameter("reg_email");
        phone = req.getParameter("reg_phone");
        password = req.getParameter("reg_password");
        System.out.println(firstname);
        System.out.println(secondname);
        System.out.println(login);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(password);
        userFunction.createUser(new User(firstname, secondname, login, email, phone, password));
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

}
