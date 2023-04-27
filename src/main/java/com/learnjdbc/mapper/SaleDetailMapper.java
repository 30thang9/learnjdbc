package com.learnjdbc.mapper;

import com.learnjdbc.model.SaleDetailModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleDetailMapper implements RowMapper<SaleDetailModel>{

    @Override
    public SaleDetailModel mapRow(ResultSet resultSet) {
        try {
            SaleDetailModel salesDetail = new SaleDetailModel();
            salesDetail.setSaleId(resultSet.getLong("saleId"));
            salesDetail.setProductLotId(resultSet.getLong("productLotId"));
            salesDetail.setQuantity(resultSet.getInt("quantity"));
            salesDetail.setPaymentPrice(resultSet.getDouble("paymentPrice"));
            return salesDetail;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
