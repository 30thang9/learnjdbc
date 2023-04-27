package com.learnjdbc.dao;

import com.learnjdbc.model.UserModel;

import java.util.List;

public interface IUserDAO extends GenericDAO<UserModel>{
    boolean save(UserModel orderModel);
    UserModel getOne(String userName);
    UserModel getUser(String userName,String passWord);
    boolean update(UserModel orderModel);
    boolean delete(long id);
    List<UserModel> getAll();
}
