package com.learnjdbc.service;

import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.util.List;

public interface IProductService {
    List<ProductModel> findByCategoryId(Long categoryId);
    ProductModel save(ProductModel productModel);
    ProductModel update(ProductModel productModel);
    void delete(long [] ids);
    List<ProductModel> getAll(Page page);
    int getTotalPage(int pageSize);
    ProductModel findOne(long id);
    List<ProductModel> getAll();
}
