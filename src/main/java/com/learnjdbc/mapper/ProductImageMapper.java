package com.learnjdbc.mapper;

import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.ProductImageModel;

import java.sql.ResultSet;

public class ProductImageMapper implements RowMapper<ProductImageModel>{
    @Override
    public ProductImageModel mapRow(ResultSet resultSet) {
        try {
            ProductImageModel piModel = new ProductImageModel();
            piModel.setId(resultSet.getLong("id"));
            piModel.setUrl(resultSet.getString("url"));
            piModel.setProductId(resultSet.getLong("productId"));
            piModel.setPosition(resultSet.getInt("position"));
            return piModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
