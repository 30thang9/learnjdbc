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
    public List<ProductModel> findByCategoryId(Long categoryId) {
        return productDAO.findByCategoryId(categoryId);
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        Long id= productDAO.save(productModel);
        return productDAO.findOne(id);
    }

    @Override
    public ProductModel update(ProductModel productModel) {
        productDAO.update(productModel);
        Long id= (long) productModel.getId();
        return productDAO.findOne(id);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
            productDAO.delete(id);
        }
    }

    @Override
    public List<ProductModel> getAll(Page page) {
        return productDAO.findAll(page);
    }

    @Override
    public int getTotalPage(int pageSize) {
        return productDAO.getTotalPage(pageSize);
    }

    @Override
    public ProductModel findOne(long id) {
        return productDAO.findOne(id);
    }

    @Override
    public List<ProductModel> getAll() {
        return productDAO.getAll();
    }
}
