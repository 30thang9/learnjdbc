package com.learnjdbc.service;


import com.learnjdbc.model.SaleDetailModel;

import java.util.List;

public interface ISaleDetailService {
	boolean save(SaleDetailModel orderModelModel);

	boolean update(SaleDetailModel orderModelModel);

	boolean delete(long[] ids);

	List<SaleDetailModel> getAll();
	Long saveGetId(SaleDetailModel orderModelModel);
}
