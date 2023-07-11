package com.learnjdbc.service;


import com.learnjdbc.model.CustomerModel;
import com.learnjdbc.model.SupplierModel;

import java.util.List;

public interface ICustomerService {
	boolean save(CustomerModel customerModel);
//	Long saveGetId(CustomerModel customerModel);
	boolean update(CustomerModel customerModel);

	boolean delete(long[] ids);

	List<CustomerModel> getAll();
	CustomerModel getOne(long id);
	List<CustomerModel> getByUsername(String username);
	Long saveGetId(CustomerModel customerModel);

    int getCount();
}
