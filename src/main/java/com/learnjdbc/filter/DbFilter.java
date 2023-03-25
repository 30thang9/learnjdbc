package com.learnjdbc.filter;

import com.learnjdbc.constant.SystemConstant;
import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.SupplierModel;
import com.learnjdbc.service.ICategoryService;
import com.learnjdbc.service.ISupplierService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DbFilter implements Filter {
    @Inject
    ICategoryService categoryService;
    @Inject
    ISupplierService supplierService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setListResult(categoryService.findAll());
        SupplierModel supplierModel=new SupplierModel();
        supplierModel.setListResult(supplierService.findAll());
        if(!req.getRequestURI().startsWith("/api")){
            req.setAttribute(SystemConstant.CATEGORY, categoryModel);
            req.setAttribute(SystemConstant.SUPPLIER,supplierModel);
            filterChain.doFilter(req, resp);
        }
    }


    @Override
    public void destroy() {

    }
}
