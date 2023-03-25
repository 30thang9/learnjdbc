package com.learnjdbc.service;


import com.learnjdbc.model.CategoryModel;
import com.learnjdbc.model.SupplierModel;

import java.util.List;

public interface ISupplierService {
	SupplierModel save(SupplierModel supplierModel);

	SupplierModel update(SupplierModel supplierModel);

	void delete(long[] ids);

	List<SupplierModel> findAll();
}
