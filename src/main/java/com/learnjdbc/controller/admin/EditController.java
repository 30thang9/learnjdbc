package com.learnjdbc.controller.admin;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.service.IProductService;
import com.learnjdbc.service.impl.ProductService;
import com.learnjdbc.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-edit"})
public class EditController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        if(type!=null){
            ProductModel model= FormUtil.toModel(ProductModel.class,req);
            model= productService.getOne(model.getId());
            req.setAttribute(SystemConstant.PRODUCT,model);
        }
        req.setAttribute("type",type);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/admin/new/edit.jsp");
        requestDispatcher.forward(req,resp);
    }
}
