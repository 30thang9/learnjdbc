package com.learnjdbc.service.impl;

import com.learnjdbc.dao.ISupplierDAO;
import com.learnjdbc.model.SupplierModel;
import com.learnjdbc.service.ISupplierService;

import javax.inject.Inject;
import java.util.List;

public class SupplierService implements ISupplierService {

    @Inject
    private ISupplierDAO supplierDAO;

    @Override
    public boolean save(SupplierModel supplierModel) {
        return supplierDAO.save(supplierModel);
    }

    @Override
    public boolean update(SupplierModel supplierModel) {
        return supplierDAO.update(supplierModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!supplierDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    @Override
    public List<SupplierModel> getAll() {
        return supplierDAO.getAll();
    }
}
