package com.learnjdbc.dao;

import com.learnjdbc.model.statisticalmodel.RevenueModel;

import java.util.List;

public interface IRevenueDAO extends GenericDAO<RevenueModel>{
    RevenueModel getSum();

    RevenueModel getSumOnCurrentDay();
    RevenueModel getSumOnCurrentMonth();
    List<RevenueModel> getSumOnMonth();
}
