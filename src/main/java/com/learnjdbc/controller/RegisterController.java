package com.learnjdbc.controller;

import com.learnjdbc.dao.IUserDAO;
import com.learnjdbc.model.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    @Inject
    IUserDAO userDAO;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String repassword=req.getParameter("repassword");
        if (username != null && password != null && repassword != null) {
            if(!password.equals(repassword)){
                req.setAttribute("MsgRePassword","The password must match the re-password");
                req.getRequestDispatcher("/views/register.jsp").forward(req,resp);
            }
            else{
                UserModel userModel=new UserModel();
                userModel.setUsername(username.trim());
                userModel.setPassword(password.trim());
                System.out.println(userModel.getUsername()+", "+userModel.getPassword());
                boolean success =userDAO.save(userModel);
                if(success){
                    resp.sendRedirect("/learnjdbc/login");
                }else{
                    req.setAttribute("MsgCreateFalse","The account is wrong or already exists");
                    req.getRequestDispatcher("/views/register.jsp").forward(req,resp);
                }
            }
        }
        else{
            req.getRequestDispatcher("/views/register.jsp").forward(req,resp);
        }
    }
}
