package com.learnjdbc.service;


import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.OrderModel;

import java.util.List;

public interface IOrderService {
	boolean save(OrderModel orderModel);

	boolean update(OrderModel orderModel);

	boolean delete(long[] ids);

	List<OrderModel> getAll();
	List<OrderModel> getByProductLotId(long productLotId);
	List<OrderModel> getByUsername(String username);
}
