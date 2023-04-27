package com.learnjdbc.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.service.impl.ProductService;
import com.learnjdbc.utils.FormUtil;
import com.learnjdbc.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setContentType("application/json");
            List<ProductModel> products = productService.getAll();
            ProductModel productModel= FormUtil.toModel(ProductModel.class,req);
            String categoryId =req.getParameter("categoryId");
            if(categoryId!=null&&!categoryId.equals("")){
                products=productService.getByCategoryId(Long.parseLong(categoryId.trim()));
            }
//            if(String.valueOf(productModel.getCategoryId())!=null&&!String.valueOf(productModel.getCategoryId()).equals("")){
//                products=productService.getByCategoryId(productModel.getCategoryId());
//            }
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(products);
            resp.getWriter().write(json);
        } catch (IOException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        try {
            ProductModel newModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
            boolean isSuccess = productService.save(newModel);
            if (isSuccess) {
                newModel= productService.getOne(newModel.getId());
                objectMapper.writeValue(resp.getOutputStream(), newModel);
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                objectMapper.writeValue(resp.getOutputStream(), "Error: Unable to save product");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            objectMapper.writeValue(resp.getOutputStream(), "Error: Invalid request body");
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        try {
            ProductModel newModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
            boolean isSuccess = productService.update(newModel);
            if (isSuccess) {
                newModel= productService.getOne(newModel.getId());
                objectMapper.writeValue(resp.getOutputStream(), newModel);
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                objectMapper.writeValue(resp.getOutputStream(), "Error: Product not found");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            objectMapper.writeValue(resp.getOutputStream(), "Error: Invalid request body");
        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // Parse request body to ProductModel object
        ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);

        // Check if ids parameter is missing
        if (productModel.getIds() == null||productModel.getIds().length == 0) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameter: ids");
            return;
        }

        try {
            // Call delete method of ProductService
            boolean isDeleted = productService.delete(productModel.getIds());

            if (isDeleted) {
                objectMapper.writeValue(resp.getOutputStream(), "{}");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


}
