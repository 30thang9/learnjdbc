package com.learnjdbc.controller;

import com.learnjdbc.model.UserModel;
import com.learnjdbc.service.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Inject
    IUserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("logout".equals(action)) {
            HttpSession session = req.getSession();
            if (session != null&&session.getAttribute("user")!=null) {
                session.removeAttribute("user"); // hủy session
            }
            if (session != null&&session.getAttribute("cart")!=null) {
                session.removeAttribute("cart"); // hủy session
            }
            resp.sendRedirect("/learnjdbc/login");
            return;
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if(username!=null&&password!=null){
            UserModel userModel= new UserModel();
            userModel=userService.getUser(username,password);
            if(userModel!=null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", userModel);
                if(userModel.getRole()==1){
                    resp.sendRedirect("/learnjdbc/admin-home");
                }else{
                    resp.sendRedirect("/learnjdbc/home");
                }
            }else{
                UserModel userModel1=new UserModel();
                userModel1=userService.getOne(username);
                if(userModel1==null){
                    req.setAttribute("MsgUsername","Account is incorrect or does not exist");
                }
                else{
                    req.setAttribute("MsgPassword","Incorrect password");
                }
                req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
            }
        }else{
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        }
    }
}
