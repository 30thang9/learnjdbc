package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.IOrderDAO;
import com.learnjdbc.mapper.OrderMapper;
import com.learnjdbc.model.OrderModel;

import java.sql.Timestamp;
import java.util.List;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO {
    @Override
    public boolean save(OrderModel orderModel) {
        String sql ="insert into Orders (productLotId,price,quantity,username,orderDate) values (?,?,?,?,?)";
        return execute(sql,orderModel.getProductLotId(),orderModel.getPrice(),orderModel.getQuantity(),
                orderModel.getUsername(),new Timestamp(System.currentTimeMillis()));
    }
    @Override
    public OrderModel getOne(long id) {
        String sql = "select * from Orders where id=? and status=0";
        List<OrderModel> orderModels=query(sql,new OrderMapper(),id);
        return orderModels.isEmpty()?null:orderModels.get(0);
    }

    @Override
    public boolean update(OrderModel orderModel) {
        String sql = "update Orders set productLotId=?, price=?, quantity=?, username=?, orderDate=?, status=? where id=?";
        return execute(sql,orderModel.getProductLotId(),orderModel.getPrice(),orderModel.getQuantity(),
                orderModel.getUsername(),new Timestamp(System.currentTimeMillis()),orderModel.getStatus(),orderModel.getId());
    }

    @Override
    public boolean delete(long id) {
        String sql="delete from Orders where id=?";
        return execute(sql,id);
    }

    @Override
    public List<OrderModel> getAll() {
        return null;
    }

    @Override
    public List<OrderModel> getByProductLotId(long productLotId) {
        String sql = "select * from Orders where productLotId=? and status=0";
        return query(sql,new OrderMapper(),productLotId);
    }

    @Override
    public List<OrderModel> getByUsername(String username) {
        String sql = "select * from Orders where username=? and status=0";
        return query(sql,new OrderMapper(),username);
    }

    @Override
    public Long saveGetId(OrderModel orderModel) {
        return null;
    }
}
