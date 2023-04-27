package com.learnjdbc.service.impl;

import com.learnjdbc.dao.IProductImageDAO;
import com.learnjdbc.model.ProductImageModel;
import com.learnjdbc.service.IProductImageService;

import javax.inject.Inject;
import java.util.List;

public class ProductImageService implements IProductImageService {
    @Inject
    IProductImageDAO productImageDAO;
    @Override
    public List<ProductImageModel> getByProductId(long productId) {
        return productImageDAO.getByProductId(productId);
    }

    @Override
    public boolean save(ProductImageModel productModel) {
        return false;
    }

    @Override
    public boolean update(ProductImageModel productModel) {
        return false;
    }

    @Override
    public boolean delete(long[] ids) {
        return false;
    }

    @Override
    public ProductImageModel getOne(long id) {
        return null;
    }

    @Override
    public List<ProductImageModel> getAll() {
        return null;
    }
}
