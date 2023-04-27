package com.learnjdbc.controller.web.cartcontroller;

import com.learnjdbc.model.OrderModel;
import com.learnjdbc.model.UserModel;
import com.learnjdbc.model.cartmodel.CartModel;
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

@WebServlet(urlPatterns = {"/remove-cart-item"})
public class RemoveCartItemController extends HttpServlet {
    @Inject
    IOrderService orderService;
    @Inject
    IProductLotService productLotService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productLotId = Long.parseLong(req.getParameter("productLotId"));
        HttpSession session = req.getSession();
        UserModel userModel = (UserModel) session.getAttribute("user");
        if (userModel != null) {
            List<OrderModel> orderModels=orderService.getByProductLotId(productLotId);
            if (orderModels != null && !orderModels.isEmpty()) {
                long[] ids = new long[1];
                ids[0]=orderModels.get(0).getId();
                orderService.delete(ids);
            }

        }else{
            CartModel cartModel = (CartModel) session.getAttribute("cart");
            if (cartModel != null) {
                cartModel.removeItem(productLotId);
                session.setAttribute("cart", cartModel);
            }
        }
    }
}
