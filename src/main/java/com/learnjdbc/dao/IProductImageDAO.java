package com.learnjdbc.dao;

import com.learnjdbc.model.ProductImageModel;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.util.List;

public interface IProductImageDAO extends GenericDAO<ProductImageModel>{
    List<ProductImageModel> getByProductId(long productId);
    boolean save(ProductImageModel productModel);
    ProductImageModel getOne(long id);
    boolean update(ProductImageModel productImageModel);
    boolean delete(long id);
    List<ProductModel> getAll();
}
