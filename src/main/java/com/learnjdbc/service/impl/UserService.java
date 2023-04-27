package com.learnjdbc.service.impl;

import com.learnjdbc.dao.IUserDAO;
import com.learnjdbc.model.UserModel;
import com.learnjdbc.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService implements IUserService {
    @Inject
    IUserDAO userDAO;
    @Override
    public boolean save(UserModel userModel) {
        return userDAO.save(userModel);
    }

    @Override
    public boolean update(UserModel userModel) {
        return userDAO.update(userModel);
    }

    @Override
    public boolean delete(long[] ids) {
        return false;
    }

    @Override
    public UserModel getUser(String username, String password) {
        return userDAO.getUser(username,password);
    }

    @Override
    public UserModel getOne(String username) {
        return userDAO.getOne(username);
    }

    @Override
    public List<UserModel> getAll() {
        return userDAO.getAll();
    }
}
