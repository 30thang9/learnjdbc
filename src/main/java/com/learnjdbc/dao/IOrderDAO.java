package com.learnjdbc.dao;

import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.OrderModel;

import java.util.List;

public interface IOrderDAO extends GenericDAO<OrderModel>{
    boolean save(OrderModel orderModel);
    OrderModel getOne(long id);
    boolean update(OrderModel orderModel);
    boolean delete(long id);
    List<OrderModel> getAll();
    List<OrderModel> getByProductLotId(long productLotId);
    List<OrderModel> getByUsername(String username);
    Long saveGetId(OrderModel orderModel);
}
