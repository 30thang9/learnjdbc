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
        Page page=new PageRequest(model.getPage(),model.getPageSize(),new Sorter(model.getSortName(), model.getSortBy()));
        model.setListResult(productService.getAll(page));
        model.setTotalPage(productService.getTotalPage(model.getPageSize()));
        req.setAttribute(SystemConstant.PRODUCT,model);
        System.out.println(model.getListResult().get(0).getHotStatus());
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/admin/new/list.jsp");
        requestDispatcher.forward(req,resp);
    }
}
