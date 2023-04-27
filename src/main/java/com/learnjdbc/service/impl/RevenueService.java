package com.learnjdbc.service.impl;

import com.learnjdbc.dao.IRevenueDAO;
import com.learnjdbc.model.statisticalmodel.RevenueModel;
import com.learnjdbc.service.IRevenueService;

import javax.inject.Inject;
import java.util.List;

public class RevenueService implements IRevenueService {
    @Inject
    IRevenueDAO revenueDAO;

    @Override
    public RevenueModel getSum() {
        return revenueDAO.getSum();
    }
    @Override
    public RevenueModel getSumOnCurrentDay() {
        return revenueDAO.getSumOnCurrentDay();
    }

    @Override
    public RevenueModel getSumOnCurrentMonth() {
        return revenueDAO.getSumOnCurrentMonth();
    }

    @Override
    public List<RevenueModel> getSumOnMonth() {
        return revenueDAO.getSumOnMonth();
    }
}
