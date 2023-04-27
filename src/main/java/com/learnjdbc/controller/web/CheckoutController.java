package com.learnjdbc.controller.web;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.*;
import com.learnjdbc.service.ICustomerService;
import com.learnjdbc.service.IProductLotService;
import com.learnjdbc.service.IProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    @Inject
    ICustomerService customerService;
    @Inject
    IProductService productService;
    @Inject
    IProductLotService productLotService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // Initialize the session object
        UserModel userModel = (UserModel) session.getAttribute("user");
        CustomerModel customerModel =new CustomerModel();
        if (userModel != null) { // If the user is logged in
            String username = userModel.getUsername();
            List<CustomerModel> customerModels = customerService.getByUsername(username);
            if (customerModels != null && !customerModels.isEmpty()) {
                customerModel=customerModels.get(0);
            }
        }
        session.setAttribute("customer", customerModel);

        ProductLotModel productLotModel =new ProductLotModel();
        productLotModel.setListResult(productLotService.getAllBySale());
        req.setAttribute(SystemConstant.PRODUCT_LOT,productLotModel);

        ProductModel productModel=new ProductModel();
        productModel.setListResult(productService.getAll());
        req.setAttribute(SystemConstant.PRODUCT,productModel);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/web/checkout.jsp");
        requestDispatcher.forward(req,resp);
    }
}
