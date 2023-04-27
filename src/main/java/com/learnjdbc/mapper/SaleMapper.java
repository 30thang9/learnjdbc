package com.learnjdbc.mapper;

import com.learnjdbc.model.SaleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMapper implements RowMapper<SaleModel>{
    @Override
    public SaleModel mapRow(ResultSet resultSet) {
        try {
            SaleModel sale = new SaleModel();
            sale.setId(resultSet.getLong("id"));
            sale.setSaleDate(resultSet.getTimestamp("saleDate"));
            sale.setTotalMoney(resultSet.getDouble("totalMoney"));
            sale.setCustomerId(resultSet.getLong("customerId"));
            return sale;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
