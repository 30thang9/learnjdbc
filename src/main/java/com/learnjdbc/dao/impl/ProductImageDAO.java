package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.IProductImageDAO;
import com.learnjdbc.mapper.ProductImageMapper;
import com.learnjdbc.mapper.RowMapper;
import com.learnjdbc.model.ProductImageModel;
import com.learnjdbc.model.ProductModel;

import java.util.List;

public class ProductImageDAO extends AbstractDAO<ProductImageModel> implements IProductImageDAO {
    @Override
    public List<ProductImageModel> getByProductId(long productId) {
        String sql = "select * from ProductImage where productId=?";
        return query(sql,new ProductImageMapper(),productId);
    }

    @Override
    public boolean save(ProductImageModel productModel) {
        return false;
    }

    @Override
    public ProductImageModel getOne(long id) {
        return null;
    }

    @Override
    public boolean update(ProductImageModel productImageModel) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<ProductModel> getAll() {
        return null;
    }
}
