package com.learnjdbc.mapper;

import com.learnjdbc.model.CustomerModel;
import com.learnjdbc.model.UserModel;

import java.sql.ResultSet;

public class CustomerMapper implements RowMapper<CustomerModel>{
    @Override
    public CustomerModel mapRow(ResultSet resultSet) {
        try {
            CustomerModel customer = new CustomerModel();
            customer.setId(resultSet.getLong("id"));
            customer.setName(resultSet.getString("name"));
            customer.setAddress(resultSet.getString("address"));
            customer.setPhone(resultSet.getString("phone"));
            customer.setEmail(resultSet.getString("email"));
            customer.setUsername(resultSet.getString("username"));
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
