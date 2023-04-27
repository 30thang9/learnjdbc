package com.learnjdbc.mapper;

import com.learnjdbc.model.OrderModel;
import com.learnjdbc.model.UserModel;

import java.sql.ResultSet;

public class OrderMapper implements RowMapper<OrderModel>{
    @Override
    public OrderModel mapRow(ResultSet resultSet) {
        try {
            OrderModel orderModel = new OrderModel();
            orderModel.setId(resultSet.getLong("id"));
            orderModel.setProductLotId(resultSet.getLong("productLotId"));
            orderModel.setPrice(resultSet.getDouble("price"));
            orderModel.setQuantity(resultSet.getInt("quantity"));
            orderModel.setOrderDate(resultSet.getTimestamp("orderDate"));
            orderModel.setUsername(resultSet.getString("username"));
            orderModel.setStatus(resultSet.getInt("status"));
            return orderModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
