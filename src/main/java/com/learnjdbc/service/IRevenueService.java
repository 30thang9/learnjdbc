package com.learnjdbc.service;

import com.learnjdbc.model.statisticalmodel.RevenueModel;

import java.util.List;

public interface IRevenueService {
    RevenueModel getSum();

    RevenueModel getSumOnCurrentDay();
    RevenueModel getSumOnCurrentMonth();
    List<RevenueModel> getSumOnMonth();
}
