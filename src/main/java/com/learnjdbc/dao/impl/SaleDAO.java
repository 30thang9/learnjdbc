package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.ISaleDAO;
import com.learnjdbc.mapper.SaleMapper;
import com.learnjdbc.model.SaleModel;

import java.sql.Timestamp;
import java.util.List;

public class SaleDAO extends AbstractDAO<SaleModel> implements ISaleDAO {
    @Override
    public boolean save(SaleModel saleModel) {
        String sql ="insert into Sale (saleDate,totalMoney,customerId) values (?,?,?)";
        return execute(sql,new Timestamp(System.currentTimeMillis()),saleModel.getTotalMoney(),saleModel.getCustomerId());
    }
    @Override
    public SaleModel getOne(long id) {
        String sql = "select * from Sale where id=?";
        List<SaleModel> saleModels=query(sql,new SaleMapper(),id);
        return saleModels.isEmpty()?null:saleModels.get(0);
    }

    @Override
    public boolean update(SaleModel saleModel) {
        String sql = "update Sale set saleDate=?,totalMoney=?, customerId=? where id=?";
        return execute(sql,saleModel.getSaleDate(),saleModel.getTotalMoney(),saleModel.getCustomerId());
    }
    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<SaleModel> getAll() {
        String sql = "select * from Sale order by id desc";
        return query(sql,new SaleMapper());
    }

    @Override
    public List<SaleModel> getByCustomerId(long customerId){
        String sql = "select * from Sale where customerId=?";
        return query(sql,new SaleMapper(),customerId);
    }
    @Override
    public Long saveGetId(SaleModel saleModel) {
        String sql ="insert into Sale (saleDate,totalMoney,customerId) values (?,?,?)";
        return insertGetId(sql,new Timestamp(System.currentTimeMillis()),saleModel.getTotalMoney(),saleModel.getCustomerId());
    }
}
