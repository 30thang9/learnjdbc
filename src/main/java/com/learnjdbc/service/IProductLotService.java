package com.learnjdbc.service;


import com.learnjdbc.model.ProductLotModel;

import java.util.List;

public interface IProductLotService {
	boolean save(ProductLotModel productLotModel);

	boolean update(ProductLotModel productLotModel);

	boolean delete(long[] ids);
	List<ProductLotModel> getAll();
	List<ProductLotModel> getAllBySale();
	ProductLotModel getOne(long id);
	List<ProductLotModel> getByProductIdAndSale(long productId);
}
