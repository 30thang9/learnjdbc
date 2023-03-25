package com.learnjdbc.dao;

import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.util.List;

public interface IProductDAO extends GenericDAO<ProductModel>{
    List<ProductModel> findByCategoryId(Long categoryId);
    Long save(ProductModel productModel);
    ProductModel findOne(Long id);
    void update(ProductModel productModel);
    void delete(long id);
    List<ProductModel> findAll(Page page);
    int getTotalPage(int pageSize);

    List<ProductModel> getAll();
}
