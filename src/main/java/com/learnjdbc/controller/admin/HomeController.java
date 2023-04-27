package com.learnjdbc.controller.admin;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.model.statisticalmodel.RevenueModel;
import com.learnjdbc.service.IProductLotService;
import com.learnjdbc.service.IProductService;
import com.learnjdbc.service.IRevenueService;
import com.learnjdbc.service.impl.ProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {
    @Inject
    private IProductService productService;
    @Inject
    private IProductLotService productLotService;
    @Inject
    IRevenueService revenueService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RevenueModel revenueModel=new RevenueModel();
        revenueModel.setSum(revenueService.getSum());
        System.out.println(revenueService.getSum().getSumMoney());
        revenueModel.setSumOnMonth(revenueService.getSumOnMonth());
        revenueModel.setSumOnCurrentMonth(revenueService.getSumOnCurrentMonth());
        revenueModel.setSumOnCurrentDay(revenueService.getSumOnCurrentDay());
        req.setAttribute("revenue",revenueModel);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/admin/home.jsp");
        requestDispatcher.forward(req,resp);
    }
}
