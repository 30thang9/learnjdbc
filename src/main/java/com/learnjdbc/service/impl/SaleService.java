package com.learnjdbc.service.impl;

import com.learnjdbc.dao.ISaleDAO;
import com.learnjdbc.model.SaleModel;
import com.learnjdbc.service.ISaleService;

import javax.inject.Inject;
import java.util.List;

public class SaleService implements ISaleService {

    @Inject
    private ISaleDAO saleDAO;

    @Override
    public boolean save(SaleModel saleModel) {
        return saleDAO.save(saleModel);
    }

    @Override
    public boolean update(SaleModel saleModel) {
        return saleDAO.update(saleModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!saleDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    @Override
    public List<SaleModel> getAll() {
        return saleDAO.getAll();
    }

    @Override
    public List<SaleModel> getByCustomerId(long customerId) {
        return saleDAO.getByCustomerId(customerId);
    }

    @Override
    public Long saveGetId(SaleModel saleModel) {
        return saleDAO.saveGetId(saleModel);
    }

}
