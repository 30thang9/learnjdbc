package com.learnjdbc.service.impl;

import com.learnjdbc.dao.IOrderDAO;
import com.learnjdbc.model.OrderModel;
import com.learnjdbc.service.IOrderService;

import javax.inject.Inject;
import java.util.List;

public class OrderService implements IOrderService {

    @Inject
    private IOrderDAO orderDAO;

    @Override
    public boolean save(OrderModel orderModel) {
        return orderDAO.save(orderModel);
    }

    @Override
    public boolean update(OrderModel orderModel) {
        return orderDAO.update(orderModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!orderDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    @Override
    public List<OrderModel> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public List<OrderModel> getByProductLotId(long productLotId) {
        return orderDAO.getByProductLotId(productLotId);
    }

    @Override
    public List<OrderModel> getByUsername(String username) {
        return orderDAO.getByUsername(username);
    }
}
