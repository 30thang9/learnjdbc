package com.learnjdbc.mapper;

import com.learnjdbc.model.statisticalmodel.RevenueModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RevenueMapper implements RowMapper<RevenueModel>{

    @Override
    public RevenueModel mapRow(ResultSet resultSet) {
        try {
        RevenueModel model = new RevenueModel();
        model.setSumMoney(resultSet.getDouble("sumMoney"));
        model.setSumQuantity(resultSet.getInt("sumQuantity"));
//        model.setMonth(resultSet.getInt("month"));
//        model.setProductId(resultSet.getLong("productId"));
        return model;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
