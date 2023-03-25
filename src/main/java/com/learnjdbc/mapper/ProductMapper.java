package com.learnjdbc.mapper;

import com.learnjdbc.model.ProductModel;

import java.sql.ResultSet;

public class ProductMapper implements RowMapper<ProductModel>{
    @Override
    public ProductModel mapRow(ResultSet resultSet) {
        try {
            ProductModel productModel = new ProductModel();
            productModel.setId(resultSet.getLong("id"));
            productModel.setProductName(resultSet.getString("productName"));
            productModel.setPrice(resultSet.getBigDecimal("price"));
            productModel.setDiscountPrice(resultSet.getBigDecimal("discountPrice"));
            productModel.setDiscountQuantity(resultSet.getInt("discountQuantity"));
            productModel.setDiscountStatus(resultSet.getBoolean("discountStatus"));
            productModel.setHotStatus(resultSet.getBoolean("hotStatus"));
            productModel.setSellingStatus(resultSet.getBoolean("sellingStatus"));
            productModel.setDescriptions(resultSet.getString("descriptions"));
            productModel.setWeight(resultSet.getFloat("weight"));
            productModel.setCategoryId(resultSet.getLong("categoryId"));
            productModel.setSupplierId(resultSet.getLong("supplierId"));
            productModel.setQuantityInstock(resultSet.getLong("quantityInstock"));
            productModel.setProductStatus(resultSet.getBoolean("productStatus"));
            productModel.setImageUrl(resultSet.getString("imageUrl"));
            productModel.setCreateBy(resultSet.getString("createBy"));
            productModel.setCreateDate(resultSet.getTimestamp("createDate"));
            productModel.setUpdateBy(resultSet.getString("updateBy"));
            productModel.setUpdateDate(resultSet.getTimestamp("updateDate"));

            return productModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
