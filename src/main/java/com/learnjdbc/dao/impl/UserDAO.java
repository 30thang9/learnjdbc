package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.IUserDAO;
import com.learnjdbc.mapper.ProductMapper;
import com.learnjdbc.mapper.UserMapper;
import com.learnjdbc.model.ProductModel;
import com.learnjdbc.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {
    @Override
    public boolean save(UserModel userModel) {
        String sql="insert into user (username,password) values (?, ?)";
        return execute(sql,userModel.getUsername(),userModel.getPassword());
    }

    @Override
    public UserModel getOne(String userName) {
        String sql = "select * from user where username = ?";
        List<UserModel> userModel=query(sql,new UserMapper(),userName);
        return userModel.isEmpty()? null: userModel.get(0);
    }

    @Override
    public UserModel getUser(String userName, String passWord) {
        String sql = "select * from user where username = ? and password = ?";
        List<UserModel> userModel=query(sql,new UserMapper(),userName,passWord);
        return userModel.isEmpty()? null: userModel.get(0);
    }

    @Override
    public boolean update(UserModel orderModel) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<UserModel> getAll() {
        return null;
    }
}
