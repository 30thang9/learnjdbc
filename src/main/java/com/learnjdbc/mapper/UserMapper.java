package com.learnjdbc.mapper;

import com.learnjdbc.model.SupplierModel;
import com.learnjdbc.model.UserModel;

import java.sql.ResultSet;

public class UserMapper implements RowMapper<UserModel>{
    @Override
    public UserModel mapRow(ResultSet resultSet) {
        try {
            UserModel userModel = new UserModel();
            userModel.setUsername(resultSet.getString("username"));
            userModel.setPassword(resultSet.getString("password"));
            userModel.setRole(resultSet.getInt("role"));
            return userModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
