package com.learnjdbc.controller.web;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.ProductImageModel;
import com.learnjdbc.model.ProductLotModel;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.service.IProductImageService;
import com.learnjdbc.service.IProductLotService;
import com.learnjdbc.service.IProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/shop-details"})
public class ShopDetailsController extends HttpServlet {
    @Inject
    IProductService productService;
    @Inject
    IProductImageService productImageService;
    @Inject
    IProductLotService  productLotService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString=req.getParameter("id");
        Integer id = Integer.parseInt(idString.trim());
        if(id!=null){
            ProductModel productModel=productService.getOne(id);
            ProductImageModel productImageModel=new ProductImageModel();
            productImageModel.setListResult(productImageService.getByProductId(id));
            ProductLotModel productLotModel=new ProductLotModel();
            productLotModel.setListResult(productLotService.getByProductIdAndSale(id));
            //System.out.println(productLotModel.getListResult().get(0).getExpirationDate().toString());
            if (productModel!=null){
                req.setAttribute(SystemConstant.PRODUCT,productModel);
                if(productImageModel!=null){
                    req.setAttribute(SystemConstant.PRODUCT_IMAGE,productImageModel);
                }
                if(productLotModel!=null){
                    req.setAttribute(SystemConstant.PRODUCT_LOT,productLotModel);
                }
            }
        }
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/web/shop-details.jsp");
        requestDispatcher.forward(req,resp);
    }
}
