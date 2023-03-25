package com.learnjdbc.service.impl;

import com.learnjdbc.dao.ICategoryDAO;
import com.learnjdbc.dao.ISupplierDAO;
import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.SupplierModel;
import com.learnjdbc.service.ICategoryService;
import com.learnjdbc.service.ISupplierService;

import javax.inject.Inject;
import java.util.List;

public class SupplierService implements ISupplierService {

    @Inject
    private ISupplierDAO supplierDAO;

    @Override
    public SupplierModel save(SupplierModel supplierModel) {
        Long id= supplierDAO.save(supplierModel);
        return supplierDAO.findOne(id);
    }

    @Override
    public SupplierModel update(SupplierModel supplierModel) {
        supplierDAO.update(supplierModel);
        Long id= (long) supplierModel.getId();
        return supplierDAO.findOne(id);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
            supplierDAO.delete(id);
        }
    }

    @Override
    public List<SupplierModel> findAll() {
        return supplierDAO.findAll();
    }
}
