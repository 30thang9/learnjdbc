package com.learnjdbc.mapper;

import com.learnjdbc.model.CategoryModel;

import java.sql.ResultSet;

public class CategoryMapper implements RowMapper<CategoryModel>{
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        try {
           CategoryModel categoryModel = new CategoryModel();
            categoryModel.setId(resultSet.getLong("id"));
            categoryModel.setCategoryName(resultSet.getString("categoryName"));
            categoryModel.setCreateBy(resultSet.getString("createBy"));
            categoryModel.setCreateDate(resultSet.getTimestamp("createDate"));
            categoryModel.setUpdateBy(resultSet.getString("updateBy"));
            categoryModel.setUpdateDate(resultSet.getTimestamp("updateDate"));
            return categoryModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
