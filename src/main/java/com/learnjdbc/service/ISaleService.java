package com.learnjdbc.service;


import com.learnjdbc.model.SaleModel;

import java.util.List;

public interface ISaleService {
	boolean save(SaleModel saleModel);

	boolean update(SaleModel saleModel);

	boolean delete(long[] ids);

	List<SaleModel> getAll();
	List<SaleModel> getByCustomerId(long productLotId);
	Long saveGetId(SaleModel saleModel);
}
