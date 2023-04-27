package com.learnjdbc.controller.admin;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.*;
import com.learnjdbc.service.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-management-sale"})
public class ManagementSaleController extends HttpServlet {
    @Inject
    ISaleService saleService;
    @Inject
    ISaleDetailService saleDetailService;
    @Inject
    ICustomerService customerService;
    @Inject
    IProductService productService;
    @Inject
    IProductLotService productLotService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SaleModel saleModel=new SaleModel();
        saleModel.setListResult(saleService.getAll());
        SaleDetailModel saleDetailModel=new SaleDetailModel();
        saleDetailModel.setListResult(saleDetailService.getAll());
        ProductModel productModel=new ProductModel();
        productModel.setListResult(productService.getAll());
        ProductLotModel productLotModel=new ProductLotModel();
        productLotModel.setListResult(productLotService.getAll());
        CustomerModel customerModel=new CustomerModel();
        customerModel.setListResult(customerService.getAll());
        req.setAttribute("sale",saleModel);
        req.setAttribute("saleDetail",saleDetailModel);
        req.setAttribute("customer",customerModel);
        req.setAttribute(SystemConstant.PRODUCT,productModel);
        req.setAttribute(SystemConstant.PRODUCT_LOT,productLotModel);
        req.getRequestDispatcher("/views/admin/sale.jsp").forward(req,resp);
    }
}
