package com.learnjdbc.dao;

import com.learnjdbc.model.SaleDetailModel;

import java.util.List;

public interface ISaleDetailDAO extends GenericDAO<SaleDetailModel>{
    boolean save(SaleDetailModel saleDetailModel);
    SaleDetailModel getOne(long id);
    boolean update(SaleDetailModel saleDetailModel);
    boolean delete(long id);
    List<SaleDetailModel> getAll();
    Long saveGetId(SaleDetailModel saleDetailModel);
}
