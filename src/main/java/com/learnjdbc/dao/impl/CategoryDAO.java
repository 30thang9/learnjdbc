package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.ICategoryDAO;
import com.learnjdbc.mapper.CategoryMapper;
import com.learnjdbc.mapper.ProductMapper;
import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.ProductModel;

import java.sql.Timestamp;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public Long save(CategoryModel categoryModel) {
        String query="INSERT INTO categories (categoryName, createBy, updateBy) " +
                "VALUES (?, ?, ?)";
        return insert(query,categoryModel.getCategoryName(),categoryModel.getCreateBy(),categoryModel.getUpdateBy());
    }

    @Override
    public CategoryModel findOne(Long id) {
        String sql = "select * from categories where id = ? ";
        List<CategoryModel> categoryModel=query(sql,new CategoryMapper(),id);
        return categoryModel.isEmpty()? null: categoryModel.get(0);
    }

    @Override
    public void update(CategoryModel categoryModel) {
        String query="update categories set categoryName=?, createBy=?, updateBy=?, updateDate=? where id=?";
        update(query,categoryModel.getCategoryName(),categoryModel.getCreateBy(),categoryModel.getUpdateBy(),
                new Timestamp(System.currentTimeMillis()),categoryModel.getId());
    }

    @Override
    public void delete(long id) {
        String query="delete from categories where id=?";
        update(query,id);
    }

    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from categories order by categoryName asc";
        return query(sql,new CategoryMapper());
    }

}
