package com.learnjdbc.dao;

import com.learnjdbc.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
    boolean save(CategoryModel productModel);
    CategoryModel getOne(long id);
    boolean update(CategoryModel productModel);
    boolean delete(long id);
    List<CategoryModel> getAll();
}
