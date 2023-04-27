package com.learnjdbc.service.impl;

import com.learnjdbc.dao.IProductDAO;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;
import com.learnjdbc.service.IProductService;

import javax.inject.Inject;
import java.util.List;

public class ProductService implements IProductService{

    @Inject
    private IProductDAO productDAO;
    @Override
    public List<ProductModel> getByCategoryId(long categoryId) {
        return productDAO.getByCategoryId(categoryId);
    }

    @Override
    public boolean save(ProductModel productModel) {
        return productDAO.save(productModel);
    }

    @Override
    public long saveGetId(ProductModel productModel) {
        return productDAO.saveGetId(productModel);
    }

    @Override
    public boolean update(ProductModel productModel) {
        return productDAO.update(productModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!productDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }


    @Override
    public List<ProductModel> getByPage(Page page) {
        return productDAO.getByPage(page);
    }

    @Override
    public int getTotalPage(Page page) {
        return productDAO.getTotalPage(page);
    }

    @Override
    public ProductModel getOne(long id) {
        return productDAO.getOne(id);
    }

    @Override
    public List<ProductModel> getAll() {
        return productDAO.getAll();
    }

    @Override
    public List<ProductModel> getBySearch(String search) {
        return productDAO.getBySearch(search);
    }
}
