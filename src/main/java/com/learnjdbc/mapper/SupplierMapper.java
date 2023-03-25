package com.learnjdbc.mapper;

import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.SupplierModel;

import java.sql.ResultSet;

public class SupplierMapper implements RowMapper<SupplierModel>{
    @Override
    public SupplierModel mapRow(ResultSet resultSet) {
        try {
            SupplierModel supplierModel = new SupplierModel();
            supplierModel.setId(resultSet.getLong("id"));
            supplierModel.setSupplierName(resultSet.getString("supplierName"));
            supplierModel.setAddress(resultSet.getString("address"));
            supplierModel.setPhone(resultSet.getString("phone"));
            supplierModel.setEmail(resultSet.getString("email"));
            supplierModel.setCreateBy(resultSet.getString("createBy"));
            supplierModel.setCreateDate(resultSet.getTimestamp("createDate"));
            supplierModel.setUpdateBy(resultSet.getString("updateBy"));
            supplierModel.setUpdateDate(resultSet.getTimestamp("updateDate"));
            return supplierModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
