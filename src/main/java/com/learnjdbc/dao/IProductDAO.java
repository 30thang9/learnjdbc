package com.learnjdbc.dao;

import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.util.List;

public interface IProductDAO extends GenericDAO<ProductModel>{
    List<ProductModel> getByCategoryId(long categoryId);
    boolean save(ProductModel productModel);

    long saveGetId(ProductModel productModel);

    ProductModel getOne(long id);
    boolean update(ProductModel productModel);
    boolean delete(long id);
    List<ProductModel> getByPage(Page page);
    int getTotalPage(Page page);

    List<ProductModel> getAll();

    List<ProductModel> getBySearch(String search);
}
