package com.learnjdbc.dao;

import com.learnjdbc.model.SupplierModel;

import java.util.List;

public interface ISupplierDAO extends GenericDAO<SupplierModel>{
    boolean save(SupplierModel supplierModel);
    SupplierModel getOne(long id);
    boolean update(SupplierModel supplierModel);
    boolean delete(long id);
    List<SupplierModel> getAll();
}
