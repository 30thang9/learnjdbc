package com.learnjdbc.mapper;

import com.learnjdbc.model.ProductModel;

import java.sql.ResultSet;

public class ProductMapper implements RowMapper<ProductModel>{
    @Override
    public ProductModel mapRow(ResultSet resultSet) {
        try {

            ProductModel productModel = new ProductModel();
            productModel.setId(resultSet.getLong("id"));
            productModel.setName(resultSet.getString("name"));
            productModel.setImportPrice(resultSet.getDouble("importPrice"));
            productModel.setExportPrice(resultSet.getDouble("exportPrice"));
            productModel.setDiscountPrice(resultSet.getDouble("discountPrice"));
            productModel.setDescriptions(resultSet.getString("descriptions"));
            productModel.setWeight(resultSet.getDouble("weight"));
            productModel.setCategoryId(resultSet.getLong("categoryId"));
            productModel.setImageUrl(resultSet.getString("imageUrl"));

            return productModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
