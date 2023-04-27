package com.learnjdbc.controller.web.cartcontroller;

import com.learnjdbc.model.*;
import com.learnjdbc.model.cartmodel.CartModel;
import com.learnjdbc.model.cartmodel.ItemModel;
import com.learnjdbc.service.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart-checkout"})
public class CartCheckoutController extends HttpServlet {
    @Inject
    ICustomerService customerService;
    @Inject
    IOrderService orderService;
    @Inject
    ISaleService saleService;
    @Inject
    ISaleDetailService saleDetailService;
    @Inject
    IProductLotService productLotService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("customerName");
        String address=req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        CustomerModel customerModel=new CustomerModel();
        customerModel.setName(name);
        customerModel.setAddress(address);
        customerModel.setPhone(phone);
        customerModel.setEmail(email);
        HttpSession session= req.getSession();
        UserModel userModel=(UserModel) session.getAttribute("user");
        CartModel cartModel=(CartModel) session.getAttribute("cart");
        if(userModel!=null){
            customerModel.setUsername(userModel.getUsername());
            CustomerModel cus=(CustomerModel)session.getAttribute("customer");
            customerModel.setId(cus.getId());
            if(cartModel!=null){
                long customerId=customerModel.getId();
                if(customerId!=0){
                    customerService.update(customerModel);
                }else{
                    customerId=customerService.saveGetId(customerModel);
                }
                SaleModel saleModel=new SaleModel();
                saleModel.setTotalMoney(cartModel.getTotalMoney());
                saleModel.setCustomerId(customerId);
                Long saleId=saleService.saveGetId(saleModel);
                List<OrderModel> orderModels=orderService.getByUsername(userModel.getUsername());
                List<SaleDetailModel> saleDetailModels=new ArrayList<SaleDetailModel>();
                for (OrderModel orderModel:orderModels){
                    SaleDetailModel saleDetailModel = new SaleDetailModel();
                    saleDetailModel.setSaleId(saleId);
                    saleDetailModel.setProductLotId(orderModel.getProductLotId());
                    saleDetailModel.setPaymentPrice(orderModel.getPrice());
                    saleDetailModel.setQuantity(orderModel.getQuantity());

                    orderModel.setStatus(1);
                    orderService.update(orderModel);
                    saleDetailModels.add(saleDetailModel);
                }
                if(!saleDetailModels.isEmpty()){
                    for(SaleDetailModel saleDetailModel:saleDetailModels){
                        saleDetailService.save(saleDetailModel);
                        ProductLotModel productLotModel= productLotService.getOne(saleDetailModel.getProductLotId());
                        productLotModel.setQuantity(productLotModel.getQuantity()-saleDetailModel.getQuantity());
                        productLotService.update(productLotModel);
                    }
                }
            }
        }else{
            long customerId=customerService.saveGetId(customerModel);
            if(cartModel!=null){
                SaleModel saleModel=new SaleModel();
                saleModel.setTotalMoney(cartModel.getTotalMoney());
                saleModel.setCustomerId(customerId);
                Long saleId=saleService.saveGetId(saleModel);
                List<SaleDetailModel> saleDetailModels=new ArrayList<SaleDetailModel>();
                for (ItemModel itemModel: cartModel.getListItems()){
                    SaleDetailModel saleDetailModel = new SaleDetailModel();
                    saleDetailModel.setSaleId(saleId);
                    saleDetailModel.setProductLotId(itemModel.getProductLotModel().getId());
                    saleDetailModel.setPaymentPrice(itemModel.getPrice());
                    saleDetailModel.setQuantity(itemModel.getQuantity());
                    saleDetailModels.add(saleDetailModel);
                }
                if(!saleDetailModels.isEmpty()){
                    for(SaleDetailModel saleDetailModel:saleDetailModels){
                        saleDetailService.save(saleDetailModel);
                        ProductLotModel productLotModel= productLotService.getOne(saleDetailModel.getProductLotId());
                        productLotModel.setQuantity(productLotModel.getQuantity()-saleDetailModel.getQuantity());
                        productLotService.update(productLotModel);
                    }
                    cartModel=new CartModel();
                    session.setAttribute("cart",cartModel);
                }
            }
        }
        resp.sendRedirect("/learnjdbc/shopping-cart");
    }
}
