package com.learnjdbc.service.impl;

import com.learnjdbc.dao.ICategoryDAO;
import com.learnjdbc.dao.impl.CategoryDAO;
import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        Long id= categoryDAO.save(categoryModel);
        return categoryDAO.findOne(id);
    }

    @Override
    public CategoryModel update(CategoryModel categoryModel) {
        categoryDAO.update(categoryModel);
        Long id= (long) categoryModel.getId();
        return categoryDAO.findOne(id);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
            categoryDAO.delete(id);
        }
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
