package com.learnjdbc.controller.web.cartcontroller;

import com.learnjdbc.model.OrderModel;
import com.learnjdbc.model.ProductLotModel;
import com.learnjdbc.model.UserModel;
import com.learnjdbc.model.cartmodel.CartModel;
import com.learnjdbc.model.cartmodel.ItemModel;
import com.learnjdbc.service.IOrderService;
import com.learnjdbc.service.IProductLotService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/add-to-cart"})
public class AddToCartController extends HttpServlet {
    @Inject
    IProductLotService productLotService;
    @Inject
    IOrderService orderService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("productLotId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        ProductLotModel productLotModel = new ProductLotModel();
        productLotModel=productLotService.getOne(id);
        ItemModel item = new ItemModel(productLotModel, quantity, price);

        HttpSession session = request.getSession();
        CartModel cartModel =null ;
        cartModel=(CartModel) session.getAttribute("cart");
        if (cartModel == null) {
            cartModel = new CartModel();
        }
        cartModel.addItem(item);
        UserModel userModel=(UserModel) session.getAttribute("user");
        if(userModel!=null){
            List<OrderModel> orderModels=orderService.getByProductLotId(item.getProductLotModel().getId());
            OrderModel orderModel=new OrderModel();
            if(orderModels!=null&&!orderModels.isEmpty()){
                orderModel.setId(orderModels.get(0).getId());
                orderModel.setProductLotId(item.getProductLotModel().getId());
                orderModel.setPrice(item.getPrice());
                orderModel.setQuantity((int) (item.getQuantity()+orderModels.get(0).getQuantity()));
                orderModel.setUsername(userModel.getUsername());
                orderService.update(orderModel);
            }else{
                orderModel.setProductLotId(item.getProductLotModel().getId());
                orderModel.setPrice(item.getPrice());
                orderModel.setQuantity(item.getQuantity());
                orderModel.setUsername(userModel.getUsername());
                orderService.save(orderModel);
            }
        }else{
            session.setAttribute("cart", cartModel);
        }
        response.sendRedirect("/learnjdbc/shopping-cart");
    }
}