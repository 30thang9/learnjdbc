package com.learnjdbc.service.impl;

import com.learnjdbc.dao.ISaleDetailDAO;
import com.learnjdbc.model.SaleDetailModel;
import com.learnjdbc.service.ISaleDetailService;

import javax.inject.Inject;
import java.util.List;

public class SaleDetailService implements ISaleDetailService {

    @Inject
    private ISaleDetailDAO saleDetailDAO;

    @Override
    public boolean save(SaleDetailModel saleDetailModel) {
        return saleDetailDAO.save(saleDetailModel);
    }

    @Override
    public boolean update(SaleDetailModel saleDetailModel) {
        return saleDetailDAO.update(saleDetailModel);
    }

    @Override
    public boolean delete(long[] ids) {
        boolean isDeleted = true;
        for (long id : ids) {
            if (!saleDetailDAO.delete(id)) {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    @Override
    public List<SaleDetailModel> getAll() {
        return saleDetailDAO.getAll();
    }

    @Override
    public Long saveGetId(SaleDetailModel saleDetailModel) {
        return saleDetailDAO.saveGetId(saleDetailModel);
    }
}
