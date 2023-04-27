package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.ICategoryDAO;
import com.learnjdbc.mapper.CategoryMapper;
import com.learnjdbc.model.CategoryModel;

import java.sql.Timestamp;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public boolean save(CategoryModel categoryModel) {
        String query="INSERT INTO Category (name) " +
                "VALUES (?)";
        return execute(query,categoryModel.getName());
    }

    @Override
    public CategoryModel getOne(long id) {
        String sql = "select * from Category where id = ? ";
        List<CategoryModel> categoryModel=query(sql,new CategoryMapper(),id);
        return categoryModel.isEmpty()? null: categoryModel.get(0);
    }

    @Override
    public boolean update(CategoryModel categoryModel) {
        String query="update Category set name=? where id=?";
        return execute(query,categoryModel.getName(),categoryModel.getId());
    }

    @Override
    public boolean delete(long id) {
        String query="delete from Category where id=?";
        return execute(query,id);
    }

    @Override
    public List<CategoryModel> getAll() {
        String sql = "select * from Category order by name asc";
        return query(sql,new CategoryMapper());
    }

}
