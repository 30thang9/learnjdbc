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

@WebServlet(urlPatterns = {"/update-cart"})
public class UpdateCartController extends HttpServlet {
    @Inject
    IOrderService orderService;
    @Inject
    IProductLotService productLotService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("productLotId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));

        ProductLotModel productLotModel = productLotService.getOne(id);
        ItemModel item = new ItemModel(productLotModel, quantity, price);

        HttpSession session = req.getSession();
        UserModel userModel = (UserModel) session.getAttribute("user");
        if (userModel != null) {
            List<OrderModel> orderModels=orderService.getByProductLotId(item.getProductLotModel().getId());
            OrderModel orderModel=new OrderModel();
            if(orderModels!=null&&!orderModels.isEmpty()) {
                orderModel.setId(orderModels.get(0).getId());
                orderModel.setProductLotId(item.getProductLotModel().getId());
                orderModel.setPrice(item.getPrice());
                orderModel.setQuantity(item.getQuantity());
                orderModel.setUsername(userModel.getUsername());
                orderService.update(orderModel);
            }
        }else{
            CartModel cartModel = (CartModel) session.getAttribute("cart");
            if (cartModel != null) {
                cartModel.updateItem(item);
                session.setAttribute("cart", cartModel);
            }
        }
        resp.sendRedirect("/learnjdbc/shopping-cart");
//        req.getRequestDispatcher("/views/web/shop-cart.jsp").forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("productLotId"));
        if (id ==null){
            System.out.println("null");
        }else {
            System.out.println(id);
        }
//        HttpSession session = req.getSession();
//        UserModel userModel = (UserModel) session.getAttribute("user");
//        if (userModel != null) {
//            List<OrderModel> orderModels=orderService.getByProductLotId(id);
//            if (orderModels != null && !orderModels.isEmpty()) {
//                long[] ids = new long[1];
//                ids[0]=orderModels.get(0).getProductLotId();
//                orderService.delete(ids);
//            }
//
//        }else{
//            CartModel cartModel = (CartModel) session.getAttribute("cart");
//            if (cartModel != null) {
//                cartModel.removeItem(id);
//                session.setAttribute("cart", cartModel);
//            }
//        }
    }
}
