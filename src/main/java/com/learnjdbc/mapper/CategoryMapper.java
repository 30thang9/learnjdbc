package com.learnjdbc.mapper;

import com.learnjdbc.model.CategoryModel;

import java.sql.ResultSet;

public class CategoryMapper implements RowMapper<CategoryModel>{
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        try {
           CategoryModel categoryModel = new CategoryModel();
            categoryModel.setId(resultSet.getLong("id"));
            categoryModel.setName(resultSet.getString("name"));
            return categoryModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
