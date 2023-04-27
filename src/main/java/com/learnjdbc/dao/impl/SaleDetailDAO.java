package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.ISaleDetailDAO;
import com.learnjdbc.mapper.SaleDetailMapper;
import com.learnjdbc.mapper.SaleMapper;
import com.learnjdbc.model.SaleDetailModel;

import java.util.List;

public class SaleDetailDAO extends AbstractDAO<SaleDetailModel> implements ISaleDetailDAO {
    @Override
    public boolean save(SaleDetailModel saleDetailModel) {
        String sql ="insert into SaleDetail (saleId,productLotId,quantity,paymentPrice) values (?,?,?,?)";
        return execute(sql,saleDetailModel.getSaleId(),saleDetailModel.getProductLotId(),saleDetailModel.getQuantity(),
                saleDetailModel.getPaymentPrice());
    }
    @Override
    public SaleDetailModel getOne(long id) {
        String sql = "select * from SaleDetail where id=?";
        List<SaleDetailModel> saleModels=query(sql,new SaleDetailMapper(),id);
        return saleModels.isEmpty()?null:saleModels.get(0);
    }

    @Override
    public boolean update(SaleDetailModel saleDetailModel) {
        String sql = "update SaleDetail set saleId=?, productLotId=?, quantity=?, paymentPrice=? where id=?";
        return execute(sql,saleDetailModel.getSaleId(),saleDetailModel.getProductLotId(),
                saleDetailModel.getQuantity(),saleDetailModel.getPaymentPrice());
    }
    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<SaleDetailModel> getAll() {
        String sql = "select * from SaleDetail ";
        return query(sql,new SaleDetailMapper());
    }
    @Override
    public Long saveGetId(SaleDetailModel saleDetailModel) {
        return null;
    }
}
