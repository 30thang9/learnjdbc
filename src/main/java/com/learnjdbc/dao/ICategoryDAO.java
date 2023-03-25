package com.learnjdbc.dao;

import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.ProductModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
    Long save(CategoryModel productModel);
    CategoryModel findOne(Long id);
    void update(CategoryModel productModel);
    void delete(long id);
    List<CategoryModel> findAll();
}
