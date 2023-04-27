package com.learnjdbc.controller.admin;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;
import com.learnjdbc.paging.PageRequest;
import com.learnjdbc.service.IProductService;
import com.learnjdbc.sort.Sorter;
import com.learnjdbc.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model= FormUtil.toModel(ProductModel.class,req);
        Page page=new PageRequest(model.getPage(),model.getPageSize(),new Sorter(model.getSortName(), model.getSortBy()),model.getSearch());
        model.setListResult(productService.getByPage(page));
        model.setTotalPage(productService.getTotalPage(page));
        req.setAttribute(SystemConstant.PRODUCT,model);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/admin/new/list.jsp");
        requestDispatcher.forward(req,resp);
    }
}
