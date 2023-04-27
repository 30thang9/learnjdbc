package com.learnjdbc.mapper;

import com.learnjdbc.model.ProductLotModel;

import java.sql.ResultSet;

public class ProductLotMapper implements RowMapper<ProductLotModel>{
    @Override
    public ProductLotModel mapRow(ResultSet resultSet) {
        try {
            ProductLotModel productLotModel = new ProductLotModel();
            productLotModel.setId(resultSet.getLong("id"));
            productLotModel.setProductId(resultSet.getLong("productId"));
            productLotModel.setProductionDate(resultSet.getTimestamp("productionDate"));
            productLotModel.setExpirationDate(resultSet.getTimestamp("expirationDate"));
            productLotModel.setQuantity(resultSet.getInt("quantity"));
            return productLotModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
