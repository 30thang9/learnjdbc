package com.learnjdbc.service;

import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.util.List;

public interface IProductService {
    List<ProductModel> getByCategoryId(long categoryId);
    boolean save(ProductModel productModel);

    long saveGetId(ProductModel productModel);

    boolean update(ProductModel productModel);
    boolean delete(long [] ids);
    List<ProductModel> getByPage(Page page);
    int getTotalPage(Page page);
    ProductModel getOne(long id);
    List<ProductModel> getAll();
    List<ProductModel> getBySearch(String search);
}
