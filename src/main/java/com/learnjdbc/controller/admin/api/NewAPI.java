package com.learnjdbc.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.service.impl.ProductService;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        ObjectMapper objectMapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel newModel =  HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        newModel = productService.save(newModel);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        objectMapper.writeValue(resp.getOutputStream(), newModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
        ObjectMapper objectMapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel newModel =  HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        newModel=productService.update(newModel);
        objectMapper.writeValue(resp.getOutputStream(),newModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
        ObjectMapper objectMapper=new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel newModel =  HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        productService.delete(newModel.getIds());
        objectMapper.writeValue(resp.getOutputStream(),"{}");
    }

}
