package com.learnjdbc.service.impl;

import com.learnjdbc.dao.ICategoryDAO;
import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public boolean save(CategoryModel categoryModel) {
        return categoryDAO.save(categoryModel);
    }

    @Override
    public boolean update(CategoryModel categoryModel) {
        return categoryDAO.update(categoryModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!categoryDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    @Override
    public List<CategoryModel> getAll() {
        return categoryDAO.getAll();
    }
}
