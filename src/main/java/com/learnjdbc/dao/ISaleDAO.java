package com.learnjdbc.dao;

import com.learnjdbc.model.SaleModel;

import java.util.List;

public interface ISaleDAO extends GenericDAO<SaleModel>{
    boolean save(SaleModel saleModel);
    SaleModel getOne(long id);
    boolean update(SaleModel saleModel);
    boolean delete(long id);
    List<SaleModel> getAll();
    List<SaleModel> getByCustomerId(long customerId);
    Long saveGetId(SaleModel saleModel);
}
