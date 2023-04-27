package com.learnjdbc.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.service.impl.ProductService;
import com.learnjdbc.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/api-search-product"})
public class SearchProductAPI extends HttpServlet {
    @Inject
    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setContentType("application/json");
            String search = req.getParameter("search");
            List<ProductModel> products = new ArrayList<ProductModel>();
            if(search!=null&&!search.equals("")){
                products=productService.getBySearch(search);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(products);
            resp.getWriter().write(json);
        } catch (IOException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

