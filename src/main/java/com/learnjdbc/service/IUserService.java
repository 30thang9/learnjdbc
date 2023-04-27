package com.learnjdbc.service;

import com.learnjdbc.model.SupplierModel;
import com.learnjdbc.model.UserModel;

import java.util.List;

public interface IUserService {
    boolean save(UserModel userModel);

    boolean update(UserModel userModel);

    boolean delete(long[] ids);

    UserModel getUser(String username,String password);
    UserModel getOne(String username);
    List<UserModel> getAll();
}
