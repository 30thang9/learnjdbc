package com.learnjdbc.dao;

import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.SupplierModel;

import java.util.List;

public interface ISupplierDAO extends GenericDAO<SupplierModel>{
    Long save(SupplierModel supplierModel);
    SupplierModel findOne(Long id);
    void update(SupplierModel supplierModel);
    void delete(long id);
    List<SupplierModel> findAll();
}
