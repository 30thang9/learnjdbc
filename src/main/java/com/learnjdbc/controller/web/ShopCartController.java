package com.learnjdbc.controller.web;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.OrderModel;
import com.learnjdbc.model.ProductLotModel;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.model.UserModel;
import com.learnjdbc.model.cartmodel.CartModel;
import com.learnjdbc.model.cartmodel.ItemModel;
import com.learnjdbc.service.IOrderService;
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

@WebServlet(urlPatterns = {"/shopping-cart"})
public class ShopCartController extends HttpServlet {
    @Inject
    IProductLotService productLotService;
    @Inject
    IOrderService orderService;
    @Inject
    IProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // Initialize the session object
        UserModel userModel = (UserModel) session.getAttribute("user");
        CartModel cartModel=null;
        if (userModel != null) { // If the user is logged in
            String username = userModel.getUsername();
            List<OrderModel> orderModels = orderService.getByUsername(username);
            cartModel = new CartModel();
            if (orderModels != null && !orderModels.isEmpty()) {
                for (OrderModel orderModel : orderModels) {
                    if (orderModel != null) {
                        ProductLotModel plm = productLotService.getOne(orderModel.getProductLotId());
                        ItemModel itemModel = new ItemModel(plm, orderModel.getQuantity(), orderModel.getPrice());
                        cartModel.addItem(itemModel);
                    }
                }
            }
            session.setAttribute("cart", cartModel);
        }
        ProductModel productModel=new ProductModel();
        productModel.setListResult(productService.getAll());
        req.setAttribute(SystemConstant.PRODUCT,productModel);

        ProductLotModel productLotModel=new ProductLotModel();
        productLotModel.setListResult(productLotService.getAllBySale());
        req.setAttribute(SystemConstant.PRODUCT_LOT,productLotModel);
        // Always dispatch to the view
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/web/shop-cart.jsp");
        requestDispatcher.forward(req,resp);
    }

}
