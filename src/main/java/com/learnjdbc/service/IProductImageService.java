package com.learnjdbc.service;

import com.learnjdbc.model.ProductImageModel;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.paging.Page;

import java.util.List;

public interface IProductImageService {
    List<ProductImageModel> getByProductId(long categoryId);
    boolean save(ProductImageModel productModel);
    boolean update(ProductImageModel productModel);
    boolean delete(long [] ids);
    ProductImageModel getOne(long id);
    List<ProductImageModel> getAll();
}
